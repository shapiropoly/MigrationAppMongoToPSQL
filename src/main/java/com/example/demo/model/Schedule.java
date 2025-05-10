package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "schedule")
@Document(collection = "Schedule")
public class Schedule {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    private String trainId;
    private String stationId;

    @Getter
    @Field("time_series")
    @ElementCollection
    @CollectionTable(
            name = "schedules_time_series",
            joinColumns = @JoinColumn(name = "schedule_id")
    )
    @Column(name = "arrival_time")
    private List<LocalTime> timeSeries;

    @PrePersist
    private void ensureId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public List<LocalTime> getTimeSeries() {
        return timeSeries;
    }

    public void setTimeSeries(List<LocalTime> timeSeries) {
        this.timeSeries = timeSeries;
    }


}