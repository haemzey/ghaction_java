package com.restaurant.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Document("menu_items")
public class MenuItem {

    @Id
    private String id;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal price;

    @NotBlank
    private String category;

    private boolean available = true;

    @PositiveOrZero
    private int preparationTimeMinutes;

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public int getPreparationTimeMinutes() { return preparationTimeMinutes; }
    public void setPreparationTimeMinutes(int preparationTimeMinutes) { this.preparationTimeMinutes = preparationTimeMinutes; }
}
