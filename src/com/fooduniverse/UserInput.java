package com.fooduniverse;

import java.util.Scanner;

public class UserInput {
    private static final UserInput instance = new UserInput();
    private final Scanner scanner = new Scanner(System.in);

    private UserInput() {
    }

    public static UserInput getInstance() {
        return instance;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public String inputText(String label) {
        System.out.print(label);
        return scanner.nextLine();
    }

    public int inputInt(String label) {
        String text = inputText(label);
        return Integer.parseInt(text);
    }

    public double inputDouble(String label) {
        String text = inputText(label);
        return Double.parseDouble(text);
    }
}