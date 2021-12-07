package com.fooduniverse.app;

import com.fooduniverse.entity.Restaurant;

import java.util.List;

public class Application {
    private List<Restaurant> restaurants;
    private Restaurant selectedRestaurant;
    private ShoppingSession shoppingSession = new ShoppingSession();

    public Application(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Restaurant getRestaurantById(String id) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId().equals(id)) {
                return restaurant;
            }
        }
        return null;
    }

    public Restaurant getSelectedRestaurant() {
        return selectedRestaurant;
    }

    public void setSelectedRestaurant(Restaurant selectedRestaurant) {
        this.selectedRestaurant = selectedRestaurant;
    }

    public ShoppingSession getShoppingSession() {
        return shoppingSession;
    }
}
