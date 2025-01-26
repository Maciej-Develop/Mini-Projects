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

    public void start() {
        view.initialDisplay();
        view.displayWhiteBoard();
        while (!model.win() && model.play()) {
            try {
                view.displayPlayer(model.getCurrentPlayer().getOption());
                model.makeMove(view.askForPosition(model.getSIZE()));
                if (model.win()) {
                    view.displayWinner(model.getCurrentPlayer().getOption());
                    again();
                } else if (!model.play()) {
                    view.displayNoWinner();
                    again();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void again() {
        if (view.askAgain()) {
            model.restart();
            view.displayWhiteBoard();
        }
    }
}
