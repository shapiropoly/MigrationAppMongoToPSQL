package com.example.demo.controller;

import com.example.demo.model.Train;
import com.example.demo.service.TrainService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Profile("!migration")
@RestController
@RequestMapping("/api/trains")
public class TrainController {
    private final TrainService service;
    public TrainController(TrainService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Train> create(@RequestBody Train t) {
        return ResponseEntity.ok(service.create(t));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> get(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Train> all() { return service.getAll(); }

    @PutMapping
    public ResponseEntity<Train> update(@RequestBody Train t) {
        return ResponseEntity.ok(service.update(t));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}