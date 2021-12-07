package com.fooduniverse.app;

import com.fooduniverse.UserInput;

public abstract class ApplicationCommand implements Command {
    protected final Application app;
    protected final UserInput userInput;

    public ApplicationCommand(Application app, UserInput userInput) {
        this.app = app;
        this.userInput = userInput;
    }
}
