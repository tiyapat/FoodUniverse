package com.fooduniverse.app;

import com.fooduniverse.UserInput;
import com.fooduniverse.entity.Restaurant;

import java.util.List;

public class SelectRestaurantCommand extends ApplicationCommand {
    public SelectRestaurantCommand(Application app, UserInput userInput) {
        super(app, userInput);
    }

    @Override
    public void execute() {
        List<Restaurant> restaurants = app.getRestaurants();
        Restaurant restaurant = null;
        while (restaurant == null) {
            String restaurantId = userInput.inputText("Enter Restaurant ID: ");
            restaurant = app.getRestaurantById(restaurantId);
            if (restaurant == null) {
                System.out.println("* Restaurant ID Not Found. Please Enter a Valid Restaurant ID. *");
            }
        }
        app.setSelectedRestaurant(restaurant);
    }
}
