package com.example.demo.service;

import com.example.demo.model.Station;

import java.util.List;
import java.util.Optional;

public interface StationService {
    Station create(Station station);
    Optional<Station> getById(String id);
    List<Station> getAll();
    Station update(Station station);
    void delete(String id);
}
