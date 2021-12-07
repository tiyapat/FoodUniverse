package com.fooduniverse.entity;

public abstract class Discount {
    private String code;
    private String description;

    public Discount(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public abstract double calculateDiscountAmount(double price);

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
