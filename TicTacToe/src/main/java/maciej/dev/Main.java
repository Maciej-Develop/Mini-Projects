package maciej.dev;

import maciej.dev.controller.Controller;
import maciej.dev.model.Model;
import maciej.dev.view.View;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);

        model.addObserver(view);
    }
}