package com.example.demo.repository.postgres;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("postgres")
public interface JpaTrainRepository
        extends TrainRepository, JpaRepository<Train, String> {}
