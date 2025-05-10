package com.example.demo.service;

import com.example.demo.model.Train;

import java.util.List;
import java.util.Optional;

public interface TrainService {
    Train create(Train train);
    Optional<Train> getById(String id);
    List<Train> getAll();
    Train update(Train train);
    void delete(String id);
}
