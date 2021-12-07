package com.fooduniverse.entity;

import java.util.List;

public class Restaurant {
    private final String id;
    private final String name;
    private final List<Food> foods;
    private final List<Discount> discounts;

    public Restaurant(String id, String name, List<Food> foods, List<Discount> discounts) {
        this.id = id;
        this.name = name;
        this.foods = foods;
        this.discounts = discounts;
    }

    public Food getFoodById(String id) {
        if (foods == null || foods.isEmpty()) return null;
        for (Food food : foods) {
            if (food.getId().equals(id)) {
                return food;
            }
        }
        return null;
    }

    public Discount getDiscountByCode(String code) {
        if (discounts == null || discounts.isEmpty()) return null;
        for (Discount discount : discounts) {
            if (discount.getCode().equals(code)) {
                return discount;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
