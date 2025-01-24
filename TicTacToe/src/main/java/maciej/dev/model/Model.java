package maciej.dev.model;

import maciej.dev.dp.Observable;

public class Model extends Observable {

    private Board board;

    public Model() {
        this.board = new Board();
    }
}
