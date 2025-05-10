package com.example.demo.repository.mongo;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
@Profile("mongo")
public interface MongoTrainRepository
        extends TrainRepository, MongoRepository<Train, String> {}