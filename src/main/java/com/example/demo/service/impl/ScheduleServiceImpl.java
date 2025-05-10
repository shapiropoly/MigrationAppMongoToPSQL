package com.example.demo.service.impl;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Profile("!migration")
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository repo;
    public ScheduleServiceImpl(ScheduleRepository repo) {
        this.repo = repo;
    }

    @Override public Schedule create(Schedule schedule) { return repo.save(schedule); }
    @Override public Optional<Schedule> getById(String id) { return repo.findById(id); }
    @Override public List<Schedule> getAll() { return (List<Schedule>) repo.findAll(); }
    @Override public Schedule update(Schedule schedule) { return repo.save(schedule); }
    @Override public void delete(String id) { repo.deleteById(id); }
}
