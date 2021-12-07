package com.fooduniverse.app;

import com.fooduniverse.UserInput;
import com.fooduniverse.entity.Food;
import com.fooduniverse.entity.Restaurant;
import com.fooduniverse.iterator.FoodIterator;

import java.util.List;

public class DisplayFoodsOfSelectedRestaurantCommand extends ApplicationCommand {
    public DisplayFoodsOfSelectedRestaurantCommand(Application app, UserInput userInput) {
        super(app, userInput);
    }

    @Override
    public void execute() {
        Restaurant restaurant = app.getSelectedRestaurant();
        List<Food> foods = restaurant.getFoods();
        int width = 50;
        String thickLine = "=".repeat(width);
        String thinLine = "-".repeat(width);
        System.out.println(thickLine);
        System.out.println(restaurant.getName() + " Food Menus");
        System.out.println(thinLine);
        System.out.printf("%5s%30s%15s\n", "ID", "Name", "Price");
        System.out.println(thinLine);
        FoodIterator iter = new FoodIterator(foods);
        while (iter.hasNext()) {
            Food food = iter.next();
            System.out.printf(
                    "%5s%30s%,15.2f\n",
                    food.getId(),
                    food.getName(),
                    food.getPrice()
            );
        }
        System.out.println(thickLine);
    }
}
