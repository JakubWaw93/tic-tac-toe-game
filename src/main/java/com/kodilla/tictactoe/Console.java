package com.kodilla.tictactoe;
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

    private static void fieldsIteration(int[][] fields, String[][] fieldsMark) {
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
    }

    public static void updateConsole() {
        if (GameStats.getVersionOfGame() == 1) {
            updateConsoleForNormalMap();
        } else {
            updateConsoleForBiggerMap();
        }
    }

    public static void updateConsoleForNormalMap() {
        String[][] fieldsMark = new String[3][3];
        int[][] fields = GameStats.getArrayOfFields();
        fieldsIteration(fields, fieldsMark);
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("1 | " + fieldsMark[0][0] + " | " + fieldsMark[0][1] + " | " + fieldsMark[0][2] + " |");
        System.out.println("2 | " + fieldsMark[1][0] + " | " + fieldsMark[1][1] + " | " + fieldsMark[1][2] + " |");
        System.out.println("3 | " + fieldsMark[2][0] + " | " + fieldsMark[2][1] + " | " + fieldsMark[2][2] + " |");
    }

    public static void updateConsoleForBiggerMap() {
        String[][] fieldsMark = new String[10][10];
        int[][] fields = GameStats.getBiggerArrayOfFields();
        fieldsIteration(fields, fieldsMark);
        System.out.println("  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 10  |");
        System.out.println("1 |  " + fieldsMark[0][0] + "  |  " + fieldsMark[0][1] + "  |  " + fieldsMark[0][2] + "  |  " + fieldsMark[0][3] + "  |  " + fieldsMark[0][4] + "  |  " + fieldsMark[0][5] +
                "  |  " + fieldsMark[0][6] + "  |  " + fieldsMark[0][7] + "  |  " + fieldsMark[0][8] + "  |  " + fieldsMark[0][9] + "  |  ");
        System.out.println("2 |  " + fieldsMark[1][0] + "  |  " + fieldsMark[1][1] + "  |  " + fieldsMark[1][2] + "  |  " + fieldsMark[1][3] + "  |  " + fieldsMark[1][4] + "  |  " + fieldsMark[1][5] +
                "  |  " + fieldsMark[1][6] + "  |  " + fieldsMark[1][7] + "  |  " + fieldsMark[1][8] + "  |  " + fieldsMark[1][9] + "  |  ");
        System.out.println("3 |  " + fieldsMark[2][0] + "  |  " + fieldsMark[2][1] + "  |  " + fieldsMark[2][2] + "  |  " + fieldsMark[2][3] + "  |  " + fieldsMark[2][4] + "  |  " + fieldsMark[2][5] +
                "  |  " + fieldsMark[2][6] + "  |  " + fieldsMark[2][7] + "  |  " + fieldsMark[2][8] + "  |  " + fieldsMark[2][9] + "  |  ");
        System.out.println("4 |  " + fieldsMark[3][0] + "  |  " + fieldsMark[3][1] + "  |  " + fieldsMark[3][2] + "  |  " + fieldsMark[3][3] + "  |  " + fieldsMark[3][4] + "  |  " + fieldsMark[3][5] +
                "  |  " + fieldsMark[3][6] + "  |  " + fieldsMark[3][7] + "  |  " + fieldsMark[3][8] + "  |  " + fieldsMark[3][9] + "  |  ");
        System.out.println("5 |  " + fieldsMark[4][0] + "  |  " + fieldsMark[4][1] + "  |  " + fieldsMark[4][2] + "  |  " + fieldsMark[4][3] + "  |  " + fieldsMark[4][4] + "  |  " + fieldsMark[4][5] +
                "  |  " + fieldsMark[4][6] + "  |  " + fieldsMark[4][7] + "  |  " + fieldsMark[4][8] + "  |  " + fieldsMark[4][9] + "  |  ");
        System.out.println("6 |  " + fieldsMark[5][0] + "  |  " + fieldsMark[5][1] + "  |  " + fieldsMark[5][2] + "  |  " + fieldsMark[5][3] + "  |  " + fieldsMark[5][4] + "  |  " + fieldsMark[5][5] +
                "  |  " + fieldsMark[5][6] + "  |  " + fieldsMark[5][7] + "  |  " + fieldsMark[5][8] + "  |  " + fieldsMark[5][9] + "  |  ");
        System.out.println("7 |  " + fieldsMark[6][0] + "  |  " + fieldsMark[6][1] + "  |  " + fieldsMark[6][2] + "  |  " + fieldsMark[6][3] + "  |  " + fieldsMark[6][4] + "  |  " + fieldsMark[6][5] +
                "  |  " + fieldsMark[6][6] + "  |  " + fieldsMark[6][7] + "  |  " + fieldsMark[6][8] + "  |  " + fieldsMark[6][9] + "  |  ");
        System.out.println("8 |  " + fieldsMark[7][0] + "  |  " + fieldsMark[7][1] + "  |  " + fieldsMark[7][2] + "  |  " + fieldsMark[7][3] + "  |  " + fieldsMark[7][4] + "  |  " + fieldsMark[7][5] +
                "  |  " + fieldsMark[7][6] + "  |  " + fieldsMark[7][7] + "  |  " + fieldsMark[7][8] + "  |  " + fieldsMark[7][9] + "  |  ");
        System.out.println("9 |  " + fieldsMark[8][0] + "  |  " + fieldsMark[8][1] + "  |  " + fieldsMark[8][2] + "  |  " + fieldsMark[8][3] + "  |  " + fieldsMark[8][4] + "  |  " + fieldsMark[8][5] +
                "  |  " + fieldsMark[8][6] + "  |  " + fieldsMark[8][7] + "  |  " + fieldsMark[8][8] + "  |  " + fieldsMark[8][9] + "  |  ");
        System.out.println("10|  " + fieldsMark[9][0] + "  |  " + fieldsMark[9][1] + "  |  " + fieldsMark[9][2] + "  |  " + fieldsMark[9][3] + "  |  " + fieldsMark[9][4] + "  |  " + fieldsMark[9][5] +
                "  |  " + fieldsMark[9][6] + "  |  " + fieldsMark[9][7] + "  |  " + fieldsMark[9][8] + "  |  " + fieldsMark[9][9] + "  |  ");
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
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("1 |1.1|1.2|1.3|");
        System.out.println("2 |2.1|2.2|2.3|");
        System.out.println("3 |3.1|3.2|3.3|");
    }

    public static void showInstructionsForBiggerMap() {
        System.out.println("To choose a field use correct Key: ");
        System.out.println("Enter 0/0 to exit the game");
        System.out.println("Enter 1 - column/row 1");
        System.out.println("Enter 2 - column/row 2");
        System.out.println("Enter 3 - column/row 3");
        System.out.println("Enter 4 - column/row 4");
        System.out.println("Enter 5 - column/row 5");
        System.out.println("Enter 6 - column/row 6");
        System.out.println("Enter 7 - column/row 7");
        System.out.println("Enter 8 - column/row 8");
        System.out.println("Enter 9 - column/row 9");
        System.out.println("Enter 10 - column/row 10");
        System.out.println("  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 10  |");
        System.out.println(" 1| 1.1 | 1.2 | 1.3 | 1.4 | 1.5 | 1.6 | 1.7 | 1.8 | 1.9 |1.10 |");
        System.out.println(" 2| 2.1 | 2.2 | 2.3 | 2.4 | 2.5 | 2.6 | 2.7 | 2.8 | 2.9 |2.10 |");
        System.out.println(" 3| 3.1 | 3.2 | 3.3 | 3.4 | 3.5 | 3.6 | 3.7 | 3.8 | 3.9 |3.10 |");
        System.out.println(" 4| 4.1 | 4.2 | 4.3 | 4.4 | 4.5 | 4.6 | 4.7 | 4.8 | 4.9 |4.10 |");
        System.out.println(" 5| 5.1 | 5.2 | 5.3 | 5.4 | 5.5 | 5.6 | 5.7 | 5.8 | 5.9 |5.10 |");
        System.out.println(" 6| 6.1 | 6.2 | 6.3 | 6.4 | 6.5 | 6.6 | 6.7 | 6.8 | 6.9 |6.10 |");
        System.out.println(" 7| 7.1 | 7.2 | 7.3 | 7.4 | 7.5 | 7.6 | 7.7 | 7.8 | 7.9 |7.10 |");
        System.out.println(" 8| 8.1 | 8.2 | 8.3 | 8.4 | 8.5 | 8.6 | 8.7 | 8.8 | 8.9 |8.10 |");
        System.out.println(" 9| 9.1 | 9.2 | 9.3 | 9.4 | 9.5 | 9.6 | 9.7 | 9.8 | 9.9 |9.10 |");
        System.out.println("10|10.1 |10.2 |10.3 |10.4 |10.5 |10.6 |10.7 |10.8 |10.9 |10.10|");
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