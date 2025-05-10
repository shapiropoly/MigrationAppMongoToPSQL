package com.example.demo.repository.mongo;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
@Profile("mongo")
public interface MongoScheduleRepository
        extends ScheduleRepository, MongoRepository<Schedule, String> {}
