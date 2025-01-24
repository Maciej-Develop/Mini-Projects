package maciej.dev.model;

public class Board {

    private final int SIZE = 3;
    private final Option[][] board;

    public Board() {
        this.board = new Option[SIZE][SIZE];
    }

    public void makeMove(Option option, Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("Non-existent position");
        } else if (this.board[position.getX()][position.getY()] != null) {
            throw new IllegalArgumentException("This case is already taken");
        } else {
            this.board[position.getX()][position.getY()] = option;
        }
    }

    private boolean contains(Position position) {
        return position.getX() < SIZE && (position.getX() >= 0 || position.getY() < SIZE) && position.getY() >= 0;
    }
}
