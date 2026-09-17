package com.restaurant.management.controller;

import com.restaurant.management.model.MenuItem;
import com.restaurant.management.repository.MenuItemRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu-items")
public class MenuItemController {

    private final MenuItemRepository repository;

    public MenuItemController(MenuItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MenuItem> list() { return repository.findAll(); }

    @GetMapping("/{id}")
    public MenuItem get(@PathVariable String id) { return repository.findById(id).orElseThrow(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuItem create(@Valid @RequestBody MenuItem item) { return repository.save(item); }

    @PutMapping("/{id}")
    public MenuItem update(@PathVariable String id, @Valid @RequestBody MenuItem item) {
        return repository.findById(id).map(existing -> {
            existing.setName(item.getName());
            existing.setDescription(item.getDescription());
            existing.setPrice(item.getPrice());
            existing.setCategory(item.getCategory());
            existing.setAvailable(item.isAvailable());
            existing.setPreparationTimeMinutes(item.getPreparationTimeMinutes());
            return repository.save(existing);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) { repository.deleteById(id); }
}
