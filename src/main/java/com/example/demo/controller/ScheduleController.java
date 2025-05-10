package com.example.demo.controller;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Profile("!migration")
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final ScheduleService service;
    public ScheduleController(ScheduleService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(service.create(schedule));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> get(@PathVariable String id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Schedule> all() { return service.getAll(); }

    @PutMapping
    public ResponseEntity<Schedule> update(@RequestBody Schedule schedule) {
        return ResponseEntity.ok(service.update(schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
