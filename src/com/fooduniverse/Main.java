package com.fooduniverse;

import com.fooduniverse.app.*;
import com.fooduniverse.entity.FixedDiscount;
import com.fooduniverse.entity.Food;
import com.fooduniverse.entity.PercentageDiscount;
import com.fooduniverse.entity.Restaurant;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Restaurant> restaurants = List.of(
                new Restaurant(
                        "msh",
                        "Magic Steak House",
                        List.of(
                                new Food("tbs", "T-Bone Steak", 250),
                                new Food("res", "Ribeye Steak", 200),
                                new Food("wgs", "Wagyu Steak", 1750)
                        ),
                        List.of(
                                new FixedDiscount("msh150", "Happy Cow Discount -100", 150),
                                new PercentageDiscount("msh5", "Celebrate Everyday -5%", 5)
                        )
                ),
                new Restaurant(
                        "tdc",
                        "Tokyo De Cuisine",
                        List.of(
                                new Food("scr", "Soft Shell Crab Roll", 390),
                                new Food("tpk", "Teppanyaki", 285)
                        ),
                        List.of(
                                new FixedDiscount("tdc100", "Happy Sunshine Day Discount -100", 100),
                                new PercentageDiscount("tdc10", "Twenty-First Century Promotion -10%", 10)
                        )
                )
        );

        Application app = new Application(restaurants);
        UserInput userInput = UserInput.getInstance();

        Command displayRestaurants = new DisplayRestaurantsCommand(app, userInput);
        Command selectRestaurant = new SelectRestaurantCommand(app, userInput);
        Command displayFoodsOfSelectedRestaurant = new DisplayFoodsOfSelectedRestaurantCommand(app, userInput);
        Command runShoppingCart = new RunShoppingCartCommand(app, userInput);

        displayRestaurants.execute();
        System.out.println();
        selectRestaurant.execute();
        displayFoodsOfSelectedRestaurant.execute();
        runShoppingCart.execute();
    }
}