package com.restaurant.management.controller;

import com.restaurant.management.model.DiningTable;
import com.restaurant.management.repository.DiningTableRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tables")
public class DiningTableController {

    private final DiningTableRepository repository;

    public DiningTableController(DiningTableRepository repository) { this.repository = repository; }

    @GetMapping
    public List<DiningTable> list() { return repository.findAll(); }

    @GetMapping("/{id}")
    public DiningTable get(@PathVariable String id) { return repository.findById(id).orElseThrow(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiningTable create(@Valid @RequestBody DiningTable table) { return repository.save(table); }

    @PutMapping("/{id}")
    public DiningTable update(@PathVariable String id, @Valid @RequestBody DiningTable table) {
        return repository.findById(id).map(existing -> {
            existing.setTableNumber(table.getTableNumber());
            existing.setCapacity(table.getCapacity());
            existing.setOccupied(table.isOccupied());
            return repository.save(existing);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) { repository.deleteById(id); }
}
