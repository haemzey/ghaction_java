package com.restaurant.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.time.Instant;

@Document("restaurant_orders")
public class RestaurantOrder {

    @Id
    private String id;

    @NotBlank
    private String customerName;

    private String tableId;

    private String items;

    private OrderStatus status = OrderStatus.RECEIVED;

    private Instant createdAt = Instant.now();

    public String getId() { return id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getTableId() { return tableId; }
    public void setTableId(String tableId) { this.tableId = tableId; }
    public String getItems() { return items; }
    public void setItems(String items) { this.items = items; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public Instant getCreatedAt() { return createdAt; }
}
