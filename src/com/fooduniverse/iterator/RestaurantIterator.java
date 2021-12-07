package com.fooduniverse.iterator;

import com.fooduniverse.entity.Restaurant;

import java.util.List;

public class RestaurantIterator implements Iterator<Restaurant> {
    private final List<Restaurant> restaurants;
    private final int size;
    int currentIndex = -1;

    public RestaurantIterator(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
        this.size = restaurants.size();
    }

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < size;
    }

    @Override
    public Restaurant next() {
        currentIndex += 1;
        return restaurants.get(currentIndex);
    }
}
