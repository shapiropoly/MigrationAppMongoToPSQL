package com.example.demo.service.impl;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Profile("!migration")
@Service
public class TrainServiceImpl implements TrainService {
    private final TrainRepository repo;
    public TrainServiceImpl(TrainRepository repo) {
        this.repo = repo;
    }

    @Override public Train create(Train train) { return repo.save(train); }
    @Override public Optional<Train> getById(String id) { return repo.findById(id); }
    @Override public List<Train> getAll() { return (List<Train>) repo.findAll(); }
    @Override public Train update(Train train) { return repo.save(train); }
    @Override public void delete(String id) { repo.deleteById(id); }
}
