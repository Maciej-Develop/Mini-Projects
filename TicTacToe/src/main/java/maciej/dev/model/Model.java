package maciej.dev.model;

import maciej.dev.dp.Observable;

public class Model extends Observable {

    private int SIZE = 3;
    private Board board;
    private boolean play;
    private Player currentPlayer;
    private Player playerX;
    private Player playerO;

    public Model() {
        this.board = new Board(SIZE);
        this.play = true;
        this.playerX = new Player(Option.X);
        this.playerO = new Player(Option.O);
        this.currentPlayer = playerX;
    }

    public int getSIZE() {
        return SIZE;
    }

    public boolean play() {
        return play;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(Position position) {
        play = !board.makeMove(currentPlayer.getOption(), position);
        if (play) {
            if (currentPlayer == playerX) {
                currentPlayer = playerO;
            } else {
                currentPlayer = playerX;
            }
        }
        notifyObservers(new Board(board));
    }

    public void restart() {
        this.board = new Board(SIZE);
        this.play = true;
        this.currentPlayer = playerX;
    }

}
