package com.example.demo.repository.postgres;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Profile("postgres")
public interface JpaScheduleRepository
        extends ScheduleRepository, JpaRepository<Schedule, String> {}
