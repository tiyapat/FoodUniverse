package com.fooduniverse.app;

import com.fooduniverse.UserInput;
import com.fooduniverse.entity.Discount;
import com.fooduniverse.entity.Restaurant;

public class CheckoutCommand extends ApplicationCommand {
    public CheckoutCommand(Application app, UserInput userInput) {
        super(app, userInput);
    }

    @Override
    public void execute() {
        Restaurant restaurant = app.getSelectedRestaurant();
        ShoppingSession shoppingSession = app.getShoppingSession();

        shoppingSession.setProceededToCheckout(true);

        System.out.println("Checkout Process");
        String discountCode = userInput.inputText("Enter A Discount Code (Press Enter To Skip): ");
        Discount discount = restaurant.getDiscountByCode(discountCode);
        if (discount != null) {
            shoppingSession.setDiscount(discount);
            System.out.println("Discount: " + discount.getDescription());
        }

        System.out.println();
        System.out.println("Delivery Options");
        System.out.println("[1] Standard Delivery.");
        System.out.println("[2] Quick Delivery.");
        String deliveryOption = userInput.inputText("Select A Delivery Option: ");
        switch (deliveryOption) {
            case "2" -> {
                double fee = 50;
                shoppingSession.setDeliveryFee(fee);
                System.out.printf("Quick Delivery Fee: %.2f Baht\n", fee);
            }
            default -> {
                double fee = 30;
                shoppingSession.setDeliveryFee(fee);
                System.out.printf("Standard Delivery Fee: %.2f Baht\n", fee);
            }
        }
    }
}
