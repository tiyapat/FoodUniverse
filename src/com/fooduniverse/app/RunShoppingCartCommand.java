package com.fooduniverse.app;

import com.fooduniverse.UserInput;
import com.fooduniverse.entity.Restaurant;

public class RunShoppingCartCommand extends ApplicationCommand {
    public RunShoppingCartCommand(Application app, UserInput userInput) {
        super(app, userInput);
    }

    @Override
    public void execute() {
        Restaurant restaurant = app.getSelectedRestaurant();
        Command addFoodIntoShoppingCart = new AddFoodIntoShoppingCartCommand(app, userInput);
        Command displayShoppingCart = new DisplayShoppingCartCommand(app, userInput);
        Command listFoodsOfSelectedRestaurant = new DisplayFoodsOfSelectedRestaurantCommand(app, userInput);
        Command checkout = new CheckoutCommand(app, userInput);
        boolean exit = false;
        do {
            System.out.println();
            System.out.println("Shopping Cart Options");
            System.out.println("[1] Add Food Into Shopping Cart.");
            System.out.println("[2] Display Shopping Cart.");
            System.out.println("[3] Display " + restaurant.getName() + " Food Menus.");
            System.out.println("[4] Checkout.");
            System.out.println("[0] Exit Shopping Cart.");
            String selection = userInput.inputText("Select An Option: ");
            System.out.println();
            switch (selection) {
                case "1" -> {
                    addFoodIntoShoppingCart.execute();
                    displayShoppingCart.execute();
                }
                case "2" -> {
                    displayShoppingCart.execute();
                }
                case "3" -> {
                    listFoodsOfSelectedRestaurant.execute();
                }
                case "4" -> {
                    checkout.execute();
                    displayShoppingCart.execute();
                    exit = true;
                }
                case "0" -> {
                    exit = true;
                }
            }
        } while (!exit);
    }
}
