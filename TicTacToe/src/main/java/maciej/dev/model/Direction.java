package maciej.dev.model;

public enum Direction {

    N(1, 0), S(-1, 0), W(0, -1), E(0, 1),
    NW(1, -1), NE(1, 1), SW(-1, -1), SE(-1, 1);

    private int x;
    private int y;

    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getOpposite() {
        switch (this) {
            case N -> {
                return S;
            }
            case S -> {
                return N;
            }
            case E -> {
                return W;
            }
            case W -> {
                return E;
            }
            case NE -> {
                return SW;
            }
            case NW -> {
                return SE;
            }
            case SE -> {
                return NW;
            }
            case SW -> {
                return NE;
            }
            default -> throw new IllegalArgumentException("Unknown direction");
        }
    }
}
