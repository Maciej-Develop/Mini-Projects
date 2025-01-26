package maciej.dev.model;

import maciej.dev.dp.Observable;

public class Model extends Observable {

    private final int SIZE = 3;
    private Board board;
    private boolean play;
    private boolean win;
    private Player currentPlayer;
    private final Player playerX;
    private final Player playerO;

    public Model() {
        this.board = new Board(SIZE);
        this.play = true;
        this.win = false;
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

    public boolean win() {
        return win;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(Position position) {
        win = board.makeMove(currentPlayer.getOption(), position);
        play = !board.isFull();
        if (!win) {
            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
        notifyObservers(new Board(board));
    }

    public void restart() {
        this.board = new Board(SIZE);
        this.play = true;
        this.win = false;
        this.currentPlayer = playerX;
    }

}
