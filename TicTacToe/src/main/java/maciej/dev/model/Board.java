package maciej.dev.model;

public class Board {

    private int size;
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
        return position.getX() < this.size && (position.getX() >= 0 || position.getY() < this.size) && position.getY() >= 0;
    }

    public Option getOption(Position position) {
        return this.board[position.getX()][position.getY()];
    }

    public int getSize() {
        return size;
    }
}
