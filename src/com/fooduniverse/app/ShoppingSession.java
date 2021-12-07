package com.fooduniverse.app;

import com.fooduniverse.entity.Discount;
import com.fooduniverse.entity.ShoppingCart;

public class ShoppingSession {
    private ShoppingCart shoppingCart = new ShoppingCart();
    private Discount discount;
    private double deliveryFee = -1;
    private boolean proceededToCheckout;

    public ShoppingSession() {
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public boolean isProceededToCheckout() {
        return proceededToCheckout;
    }

    public void setProceededToCheckout(boolean proceededToCheckout) {
        this.proceededToCheckout = proceededToCheckout;
    }
}
