package com.restaurant.management.repository;

import com.restaurant.management.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
}
