package com.restaurant.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Document("dining_tables")
public class DiningTable {

    @Id
    private String id;

    @NotBlank
    private String tableNumber;

    @Positive
    private int capacity;

    private boolean occupied;

    public String getId() { return id; }
    public String getTableNumber() { return tableNumber; }
    public void setTableNumber(String tableNumber) { this.tableNumber = tableNumber; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }
}
