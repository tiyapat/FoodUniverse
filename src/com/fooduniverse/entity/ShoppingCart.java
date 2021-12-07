package com.fooduniverse.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (ShoppingCartItem item : items) {
            totalPrice += item.getSubtotalPrice();
        }
        return totalPrice;
    }

    public void addFood(Food food, int quantity) {
        ShoppingCartItem item = new ShoppingCartItem(food, quantity);
        items.add(item);
    }
}
