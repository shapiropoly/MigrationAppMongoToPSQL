package com.example.demo.repository;

import com.example.demo.model.Train;
import org.springframework.data.repository.CrudRepository;

public interface TrainRepository extends CrudRepository<Train, String> {}

