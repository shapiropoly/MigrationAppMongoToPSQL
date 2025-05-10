package com.example.demo.service;

import com.example.demo.model.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    Schedule create(Schedule schedule);
    Optional<Schedule> getById(String id);
    List<Schedule> getAll();
    Schedule update(Schedule schedule);
    void delete(String id);
}
