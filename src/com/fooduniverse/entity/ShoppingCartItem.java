package com.fooduniverse.entity;

public class ShoppingCartItem {
    private Food food;
    private int quantity;

    public ShoppingCartItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotalPrice() {
        return this.food.getPrice() * this.quantity;
    }
}
