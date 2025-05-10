package com.example.demo;

import com.example.demo.model.Schedule;
import com.example.demo.model.Station;
import com.example.demo.model.Train;
import com.example.demo.repository.mongo.MongoScheduleRepository;
import com.example.demo.repository.mongo.MongoStationRepository;
import com.example.demo.repository.mongo.MongoTrainRepository;
import com.example.demo.repository.postgres.JpaScheduleRepository;
import com.example.demo.repository.postgres.JpaStationRepository;
import com.example.demo.repository.postgres.JpaTrainRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import org.springframework.data.geo.Point;

import static java.util.stream.Collectors.toList;

@SpringBootApplication(
        exclude = {
                org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration.class
        })
@Profile("migration")
public class MigratorApp implements CommandLineRunner {

    private final MongoTrainRepository mongoTrainRepo;
    private final MongoStationRepository mongoStationRepo;
    private final MongoScheduleRepository mongoScheduleRepo;

    private final JpaTrainRepository pgTrainRepo;
    private final JpaStationRepository pgStationRepo;
    private final JpaScheduleRepository pgScheduleRepo;


    public MigratorApp(MongoTrainRepository mongoTrainRepo,
                       JpaTrainRepository   pgTrainRepo,
                       MongoStationRepository mongoStationRepo,
                       JpaStationRepository pgStationRepo,
                       MongoScheduleRepository mongoScheduleRepo,
                       JpaScheduleRepository pgScheduleRepo) {
        this.mongoTrainRepo = mongoTrainRepo;
        this.pgTrainRepo    = pgTrainRepo;
        this.mongoStationRepo = mongoStationRepo;
        this.pgStationRepo = pgStationRepo;
        this.mongoScheduleRepo = mongoScheduleRepo;
        this.pgScheduleRepo = pgScheduleRepo;
    }

    @Override
    public void run(String... args) {

        List<Train> trains = mongoTrainRepo.findAll();
        pgTrainRepo.saveAll(trains);

        List<Station> stations = mongoStationRepo.findAll().stream()
                .peek(st -> st.setLocation(
                        new Point(st.getLongitude(), st.getLatitude())))
                .collect(toList());

        pgStationRepo.saveAll(stations);

        List<Schedule> schedules =
                mongoScheduleRepo.findAll()
                        .stream()
                        .peek(MigratorApp::normalizeTimes)
                        .toList();

        pgScheduleRepo.saveAll(schedules);

        System.out.println("===  Migration finished successfully  ===");
        System.exit(0);
    }

    private static void normalizeTimes(Schedule s) {
        List<?> src = s.getTimeSeries();
        if (src == null || src.isEmpty()) return;

        if (src.get(0) instanceof LocalTime) return;

        List<LocalTime> fixed = src.stream()
                .map(MigratorApp::asLocalTime)
                .toList();
        s.setTimeSeries(fixed);
    }

    private static LocalTime asLocalTime(Object o) {
        if (o instanceof Date d) {
            return LocalTime.ofInstant(d.toInstant(), ZoneOffset.UTC);
        }
        if (o instanceof LocalDateTime ldt) {
            return ldt.toLocalTime();
        }
        if (o instanceof LocalTime lt) {
            return lt;
        }
        throw new IllegalArgumentException("Неизвестный тип времени: " + o.getClass());
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(MigratorApp.class)
                .profiles("migration","mongo","postgres")
                .logStartupInfo(false)
                .run(args);
    }
}

