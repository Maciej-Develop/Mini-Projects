package maciej.dev.view;

import maciej.dev.dp.Observable;
import maciej.dev.dp.Observer;
import maciej.dev.model.Board;
import maciej.dev.model.Option;
import maciej.dev.model.Position;

import java.util.Scanner;

public class View implements Observer {

    Scanner scanner = new Scanner(System.in);

    public void initialDisplay() {
        System.out.println("Hello in TicTacToe");
    }

    public void displayWhiteBoard() {
        System.out.println("|   |   |   |\n" +
                "-------------\n" +
                "|   |   |   |\n" +
                "-------------\n" +
                "|   |   |   |");
    }

    public void displayPlayer(Option option) {
        System.out.println("It's " + option.toString() + " player's turn");
    }

    public Position askForPosition(int limit) {
        int x = askForInteger("Please enter a x position : ", limit);
        int y = askForInteger("Please enter a y position : ", limit);
        return new Position(x, y);
    }

    public int askForInteger(String message, int limit) {
        System.out.println(message);
        int x = Integer.parseInt(scanner.nextLine());
        while (x < 1 || x > limit) {
            System.out.println("Enter a number between 1 and " + limit + ", both included");
            x = Integer.parseInt(scanner.nextLine());
        }
        return x - 1;
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (arg instanceof Board) {
            displayBoard((Board) arg);
        }
    }

    private void displayBoard(Board board) {
        for (int i = 0; i < board.getSize(); i++) {
            System.out.print("|");
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getOption(new Position(i, j)) == Option.O) {
                    System.out.print(" O |");
                } else if (board.getOption(new Position(i, j)) == Option.X) {
                    System.out.print(" X |");
                } else {
                    System.out.print("   |");
                }
            }
            System.out.println();
            if (i != board.getSize() - 1) {
                System.out.println("-------------");
            }
        }
    }
}
