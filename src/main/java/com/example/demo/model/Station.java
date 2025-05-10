package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.data.geo.Point;

import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Entity
@Table(name = "station")
@Document(collection = "Station")
public class Station {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    private String name;

    @TextIndexed
    private String description;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Transient
    public Point getLocation() {
        return new Point(longitude, latitude);
    }

    @Transient
    public void setLocation(Point point) {
        this.longitude = point.getX();
        this.latitude = point.getY();
    }

    @PrePersist
    private void ensureId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }

    public String getId()            { return id; }
    public String getName()          { return name; }
    public String getDescription()   { return description; }
    public double getLatitude()      { return latitude; }
    public double getLongitude()     { return longitude; }

    public void setId(String id)                 { this.id = id; }
    public void setName(String name)             { this.name = name; }
    public void setDescription(String desc)      { this.description = desc; }
    public void setLatitude(double latitude)     { this.latitude  = latitude; }
    public void setLongitude(double longitude)   { this.longitude = longitude; }
}