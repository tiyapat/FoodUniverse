package com.fooduniverse.iterator;

import com.fooduniverse.entity.Food;

import java.util.List;

public class FoodIterator implements Iterator<Food> {
    private final List<Food> foods;
    private final int size;
    int currentIndex = -1;

    public FoodIterator(List<Food> foods) {
        this.foods = foods;
        this.size = foods.size();
    }

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < size;
    }

    @Override
    public Food next() {
        currentIndex += 1;
        return foods.get(currentIndex);
    }
}
