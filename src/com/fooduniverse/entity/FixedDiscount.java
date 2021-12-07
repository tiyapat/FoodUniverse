package com.fooduniverse.entity;

public class FixedDiscount extends Discount {
    private final double amount;

    public FixedDiscount(String code, String description, double amount) {
        super(code, description);
        this.amount = amount;
    }

    @Override
    public double calculateDiscountAmount(double price) {
        return amount;
    }

    public double getAmount() {
        return amount;
    }
}
