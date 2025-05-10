package com.example.demo.repository.mongo;

import com.example.demo.model.Station;
import com.example.demo.repository.StationRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
@Profile("mongo")
public interface MongoStationRepository
        extends StationRepository, MongoRepository<Station, String> {}
