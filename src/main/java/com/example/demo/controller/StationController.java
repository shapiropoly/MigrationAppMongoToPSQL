package com.example.demo.controller;

import com.example.demo.model.Station;
import com.example.demo.service.StationService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Profile("!migration")
@RestController
@RequestMapping("/api/stations")
public class StationController {
    private final StationService service;
    public StationController(StationService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Station> create(@RequestBody Station station) {
        return ResponseEntity.ok(service.create(station));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Station> get(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Station> all() { return service.getAll(); }

    @PutMapping
    public ResponseEntity<Station> update(@RequestBody Station station) {
        return ResponseEntity.ok(service.update(station));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
