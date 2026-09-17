package com.restaurant.management.repository;

import com.restaurant.management.model.RestaurantOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestaurantOrderRepository extends MongoRepository<RestaurantOrder, String> {
}
