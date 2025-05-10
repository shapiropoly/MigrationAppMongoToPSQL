package com.example.demo.repository.postgres;

import com.example.demo.model.Station;
import com.example.demo.repository.StationRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Profile("postgres")
public interface JpaStationRepository
        extends StationRepository, JpaRepository<Station, String> {}