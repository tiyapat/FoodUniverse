package com.fooduniverse.entity;

public class PercentageDiscount extends Discount {
    private final double percentage;

    public PercentageDiscount(String code, String description, double percentage) {
        super(code, description);
        this.percentage = percentage;
    }

    @Override
    public double calculateDiscountAmount(double price) {
        return price * percentage / 100;
    }

    public double getPercentage() {
        return percentage;
    }
}
