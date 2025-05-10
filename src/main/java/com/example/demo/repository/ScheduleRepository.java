package com.example.demo.repository;

import com.example.demo.model.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, String> {}

