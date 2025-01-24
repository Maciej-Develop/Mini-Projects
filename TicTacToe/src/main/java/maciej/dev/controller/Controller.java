package maciej.dev.controller;

import maciej.dev.model.Model;
import maciej.dev.view.View;

public class Controller {

    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }
}
