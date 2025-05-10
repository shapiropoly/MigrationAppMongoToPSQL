package com.example.demo.repository;

import com.example.demo.model.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, String> {}
