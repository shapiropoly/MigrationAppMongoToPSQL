package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "train")
@Document(collection = "Train")
public class Train {

    @Id
    @Column(name = "id", length = 36)
    private String id;

    private String name;
    private int capacity;

    @PrePersist
    private void ensureId() {
        if (this.id == null) {
            this.id = UUID.randomUUID().toString();
        }
    }
}