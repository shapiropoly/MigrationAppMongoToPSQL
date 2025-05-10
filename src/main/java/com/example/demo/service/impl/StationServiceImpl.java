package com.example.demo.service.impl;

import com.example.demo.model.Station;
import com.example.demo.repository.StationRepository;
import com.example.demo.service.StationService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Profile("!migration")
@Service
public class StationServiceImpl implements StationService {
    private final StationRepository repo;
    public StationServiceImpl(StationRepository repo) {
        this.repo = repo;
    }

    @Override public Station create(Station station) { return repo.save(station); }
    @Override public Optional<Station> getById(String id) { return repo.findById(id); }
    @Override public List<Station> getAll() { return (List<Station>) repo.findAll(); }
    @Override public Station update(Station station) { return repo.save(station); }
    @Override public void delete(String id) { repo.deleteById(id); }
}
