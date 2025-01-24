package maciej.dev.model;

import maciej.dev.model.tools.State;

import java.util.Random;

public class Board {

    private final int height;
    private final int width;
    private Entity[][] board;

    public Board() {
        this.height = 10;
        this.width = 30;
        this.board = new Entity[height][width];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                this.board[i][j] = new Entity(State.DEAD);
            }
        }
        startPopulation();
    }

    private void startPopulation() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(this.height);
            int y = r.nextInt(this.width);
            if (this.board[x][y].getState() == State.DEAD) {
                this.board[x][y].setState(State.ALIVE);
            } else {
                i--;
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Entity getEntity(int x, int y) {
        return this.board[x][y];
    }
}
