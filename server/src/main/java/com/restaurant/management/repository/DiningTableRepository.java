package com.restaurant.management.repository;

import com.restaurant.management.model.DiningTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiningTableRepository extends MongoRepository<DiningTable, String> {
}
