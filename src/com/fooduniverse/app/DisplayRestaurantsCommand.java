package com.fooduniverse.app;

import com.fooduniverse.UserInput;
import com.fooduniverse.entity.Restaurant;
import com.fooduniverse.iterator.RestaurantIterator;

import java.util.List;

public class DisplayRestaurantsCommand extends ApplicationCommand {
    public DisplayRestaurantsCommand(Application app, UserInput userInput) {
        super(app, userInput);
    }

    @Override
    public void execute() {
        List<Restaurant> restaurants = app.getRestaurants();
        int width = 35;
        String thickLine = "=".repeat(width);
        String thinLine = "-".repeat(width);
        String template = "%5s%30s\n";
        System.out.println(thickLine);
        System.out.println("Restaurants");
        System.out.println(thinLine);
        System.out.printf(template, "ID", "Name");
        System.out.println(thinLine);
        RestaurantIterator iter = new RestaurantIterator(restaurants);
        while (iter.hasNext()) {
            Restaurant restaurant = iter.next();
            System.out.printf(template, restaurant.getId(), restaurant.getName());
        }
        System.out.println(thickLine);
    }
}
