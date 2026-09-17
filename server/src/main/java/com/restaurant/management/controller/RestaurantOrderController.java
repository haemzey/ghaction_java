package com.restaurant.management.controller;

import com.restaurant.management.model.OrderStatus;
import com.restaurant.management.model.RestaurantOrder;
import com.restaurant.management.repository.RestaurantOrderRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class RestaurantOrderController {

    private final RestaurantOrderRepository repository;

    public RestaurantOrderController(RestaurantOrderRepository repository) { this.repository = repository; }

    @GetMapping
    public List<RestaurantOrder> list() { return repository.findAll(); }

    @GetMapping("/{id}")
    public RestaurantOrder get(@PathVariable String id) { return repository.findById(id).orElseThrow(); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantOrder create(@Valid @RequestBody RestaurantOrder order) { return repository.save(order); }

    @PatchMapping("/{id}/status")
    public RestaurantOrder updateStatus(@PathVariable String id, @RequestParam OrderStatus status) {
        return repository.findById(id).map(order -> {
            order.setStatus(status);
            return repository.save(order);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) { repository.deleteById(id); }
}
