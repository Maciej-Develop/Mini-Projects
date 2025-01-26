package maciej.dev.model;

import java.util.List;

public class Board {

    private final int size;
    private final Option[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new Option[this.size][this.size];
    }

    public Board(Board board) {
        this.size = board.getSize();
        this.board = new Option[board.getSize()][board.getSize()];
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                this.board[i][j] = board.getOption(new Position(i, j));
            }
        }
    }

    public boolean makeMove(Option option, Position position) {
        if (!contains(position)) {
            throw new IllegalArgumentException("Non-existent position");
        } else if (this.board[position.getX()][position.getY()] != null) {
            throw new IllegalArgumentException("This case is already taken");
        } else {
            this.board[position.getX()][position.getY()] = option;
        }
        return checkWin(option, position);
    }

    private boolean contains(Position position) {
        return (position.getX() < this.size && position.getX() >= 0) && (position.getY() < this.size && position.getY() >= 0);
    }

    public Option getOption(Position position) {
        return this.board[position.getX()][position.getY()];
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.getOption(new Position(i, j)) == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin(Option option, Position position) {
        int cpt = 1;
        for (Direction dir : List.of(Direction.N, Direction.NW, Direction.NE, Direction.E)) {
            cpt += checkDirection(option, position, dir);
            cpt += checkDirection(option, position, dir.getOpposite());
            if (cpt == 3) {
                return true;
            }
            cpt = 1;
        }
        return false;
    }

    private int checkDirection(Option option, Position position, Direction direction) {
        int cpt = 0;
        for (int i = 1; i < 3; i++) {
            Position pos = new Position(position.getX() + (i * direction.getX()), position.getY() + (i * direction.getY()));
            if (this.contains(pos) && this.getOption(pos) == option) {
                cpt++;
            } else {
                break;
            }
        }
        return cpt;
    }
}
