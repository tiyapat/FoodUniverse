package com.fooduniverse.app;

import com.fooduniverse.UserInput;
import com.fooduniverse.entity.Food;
import com.fooduniverse.entity.Restaurant;
import com.fooduniverse.entity.ShoppingCart;

public class AddFoodIntoShoppingCartCommand extends ApplicationCommand {
    public AddFoodIntoShoppingCartCommand(Application app, UserInput userInput) {
        super(app, userInput);
    }

    @Override
    public void execute() {
        Restaurant restaurant = app.getSelectedRestaurant();
        ShoppingCart shoppingCart = app.getShoppingSession().getShoppingCart();
        Food food = null;
        while (food == null) {
            System.out.println("Add Food Into Shopping Cart.");
            String foodId = userInput.inputText("Enter Food ID: ");
            food = restaurant.getFoodById(foodId);
            if (food == null) {
                System.out.println("* Food ID Not Found. Please Enter a Valid Food ID. *");
                System.out.println();
            }
        }
        int quantity = userInput.inputInt("Enter Quantity: ");
        shoppingCart.addFood(food, quantity);
    }
}
