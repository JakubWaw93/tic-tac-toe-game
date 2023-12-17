package com.kodilla.tictactoe;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class Console {

    private static final Scanner input = new Scanner(System.in);
    static GameRanking gameRanking = new GameRanking();

    public static String howManyPlayers() {
        System.out.println("1 Player or 2 Players? ('1'/'2')");
        return input.nextLine();
    }

    public static String whatVersionOfGame() {
        System.out.println("Enter '1' to play classic, or enter '2' to play extended version of the game.");
        return input.nextLine();
    }
    public static void updateConsole() {
        if (GameStats.getVersionOfGame() == 1) {
            consoleUpdate(GameStats.getArrayOfFields());
        } else {
            consoleUpdate(GameStats.getBiggerArrayOfFields());
        }
    }
    public static void consoleUpdate(int[][] fields) {
        String[][] fieldsMark = new String[fields.length][fields.length];
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fieldsMark[i][j] = " ";
                if (fields[i][j] == 1) {
                    fieldsMark[i][j] = "O";
                } else if (fields[i][j] == 2) {
                    fieldsMark[i][j] = "X";
                }
            }
        }
        System.out.print("  |");
        for (int j = 1; j <= fields.length; j++ ) {
            if (j < 10) {
                System.out.print("  " + j + "  |");
            } else {
                System.out.print("  " + j + " |");
            }
        }
        System.out.print("\n");
        for (int i = 0; i < fields.length; i++) {
            if (i +1 < 10) {
                System.out.print(i + 1 + " |");
            } else {
                System.out.print(i + 1 + "|");
            }
            for (int j = 0; j < fields.length; j++) {
                System.out.print("  " + fieldsMark[i][j] + "  |");
            }
            System.out.print("\n");
        }
    }

    public static void showWinner() {
        if (GameStats.getWinnerPlayer() == 1) {
            System.out.println("The winner is: " + GameStats.getPlayer1Name());
        } else if (GameStats.getWinnerPlayer() == 2) {
            System.out.println("The winner is: " + GameStats.getPlayer2Name());
        } else {
            System.out.println("It's a draw.");
        }
    }

    public static void showInstructions() {
        System.out.println("To choose a field use correct Key: ");
        System.out.println("Enter 0/0 to exit the game");
        System.out.println("Key 1 - column/row 1");
        System.out.println("Key 2 - column/row 2");
        System.out.println("Key 3 - column/row 3");
        System.out.println("...");
        System.out.println("  | 1 | 2 | 3 | ");
        System.out.println("1 |1.1|1.2|1.3| ");
        System.out.println("2 |2.1|2.2|2.3| ");
        System.out.println("3 |3.1|3.2|3.3| ...");
    }

    public static void whoseTurn() {
        if (GameStats.getTurnOfPlayer() == 1) {
            System.out.println(GameStats.getPlayer1Name() + " turn.");
        } else if (GameStats.getTurnOfPlayer() == 2) {
            System.out.println(GameStats.getPlayer2Name() + " turn.");
        }
    }

    public static String moveReaderColumns() {
        System.out.println("Choose a column: ");
        return input.nextLine();
    }

    public static String moveReaderRows() {
        System.out.println("Choose a row: ");
        return input.nextLine();
    }

    public static void numberFormatExceptionMessage() {
        System.out.println("You have to choose a number.");
    }

    public static void exceptionMessage(String s) {
        System.out.println(s);
    }

    public static void showPoints() {
        System.out.println("Round: " + GameStats.getRound());
        System.out.println(GameStats.getPlayer1Name() + " points: " + GameStats.getPlayer1Points() + "\n" + GameStats.getPlayer2Name() + " points: "
                + GameStats.getPlayer2Points());
    }

    public static String sayYourName1() {
        System.out.println("Player 1 name: ");
        return input.nextLine();
    }

    public static String sayYourName2() {
        System.out.println("Player 2 name: ");
        return input.nextLine();
    }

    public static String playAgain() {
        System.out.println("Do You want to play again? (1-YES/2-NO)");
        return input.nextLine();
    }

    public static void farewell() {
        System.out.println("Until next time...");
    }

    public static void showRanking() {
        System.out.println("Players / Wins");
        Map<String, Integer> map = gameRanking.getLocalMapForRanking();
        gameRanking.loadMap();

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> {
                    System.out.println("Player: " + entry.getKey() + ", Wins: " + entry.getValue());
                });
    }

}