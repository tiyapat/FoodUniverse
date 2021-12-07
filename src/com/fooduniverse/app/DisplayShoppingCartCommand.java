package com.fooduniverse.app;

import com.fooduniverse.UserInput;
import com.fooduniverse.entity.Discount;
import com.fooduniverse.entity.Food;
import com.fooduniverse.entity.ShoppingCart;
import com.fooduniverse.entity.ShoppingCartItem;

import java.util.List;

public class DisplayShoppingCartCommand extends ApplicationCommand {
    public DisplayShoppingCartCommand(Application app, UserInput userInput) {
        super(app, userInput);
    }

    @Override
    public void execute() {
        ShoppingSession shoppingSession = app.getShoppingSession();
        ShoppingCart shoppingCart = shoppingSession.getShoppingCart();
        List<ShoppingCartItem> items = shoppingCart.getItems();
        int width = 95;
        String thickLine = "=".repeat(width);
        String thinLine = "-".repeat(width);
        System.out.println(thickLine);
        if (!shoppingSession.isProceededToCheckout()) {
            System.out.println("Shopping Cart");
            System.out.println(thinLine);
        }
        System.out.printf("%5s%30s%20s%20s%20s\n", "ID", "Name", "Unit Price", "Quantity", "Subtotal Price");
        System.out.println(thinLine);
        for (ShoppingCartItem item : items) {
            Food food = item.getFood();
            System.out.printf(
                    "%5s%30s%,20.2f%,20d%,20.2f\n",
                    food.getId(),
                    food.getName(),
                    food.getPrice(),
                    item.getQuantity(),
                    item.getSubtotalPrice()
            );
        }
        System.out.println(thinLine);
        double totalPrice = shoppingCart.getTotalPrice();
        String footerLineTemplate = "%75s%,20.2f\n";
        System.out.printf(footerLineTemplate, "Total Price", totalPrice);
        double netPrice = totalPrice;
        if (shoppingSession.isProceededToCheckout()) {
            Discount discount = shoppingSession.getDiscount();
            if (discount != null) {
                double discountAmount = discount.calculateDiscountAmount(totalPrice);
                netPrice -= discountAmount;
                System.out.printf(footerLineTemplate, "Discount: " + discount.getDescription(), -discountAmount);
            }
            double deliveryFee = shoppingSession.getDeliveryFee();
            if (deliveryFee != -1) {
                netPrice += deliveryFee;
                System.out.printf(footerLineTemplate, "Delivery Fee", deliveryFee);
            }
            System.out.printf(footerLineTemplate, "Net Price", netPrice);
        }
        System.out.println(thickLine);
    }
}
