package com.kodilla.tictactoe;

public class GameStats {

    private static int numberOfPlayers=0;
    static final int [][] arrayOfFields = new int [3][3];
    static final int [][] biggerArrayOfFields = new int [10][10];
    private static int turnOfPlayer;
    private static boolean end = false;
    private static boolean totalEnd = false;
    private static int winnerPlayer=0;
    private static int player1Points;
    private static int player2Points;
    private static int versionOfGame=0;
    private static String player1Name;
    private static String player2Name;
    private static int round=0;

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static int getTurnOfPlayer() {
        return turnOfPlayer;
    }

    public static boolean isEnd() {
        return end;
    }

    public static boolean isTotalEnd() {
        return totalEnd;
    }

    public static int getWinnerPlayer() {
        return winnerPlayer;
    }

    public static int getPlayer1Points() {
        return player1Points;
    }

    public static int getPlayer2Points() {
        return player2Points;
    }

    public static int getVersionOfGame() {
        return versionOfGame;
    }

    public static String getPlayer1Name() {
        return player1Name;
    }

    public static String getPlayer2Name() {
        return player2Name;
    }

    public static int getRound() {
        return round;
    }

    public static void setTurnOfPlayer(int turnOfPlayer) {
        GameStats.turnOfPlayer = turnOfPlayer;
    }

    public static void setWinnerPlayer(int winnerPlayer) {
        GameStats.winnerPlayer = winnerPlayer;
    }

    public static void setEnd(boolean end) {
        GameStats.end = end;
    }

    public static void setTotalEnd(boolean totalEnd) {
        GameStats.totalEnd = totalEnd;
    }

    public static void setRound(int round) {
        GameStats.round = round;
    }

     public static int[][] getArrayOfFields() {
        return arrayOfFields;
    }
    public static int[][] getBiggerArrayOfFields() {
        return biggerArrayOfFields;
    }

    public static void setPlayer1Points(int player1Points) {
        GameStats.player1Points = player1Points;
    }

    public static void setPlayer2Points(int player2Points) {
        GameStats.player2Points = player2Points;
    }

    public static void setPlayer1Name(String player1Name) {
        GameStats.player1Name = player1Name;
    }

    public static void setPlayer2Name(String player2Name) {
        GameStats.player2Name = player2Name;
    }

    public static void setNumberOfPlayers(int numberOfPlayers) {
        GameStats.numberOfPlayers = numberOfPlayers;
    }

    public static void setVersionOfGame(int versionOfGame) {
        GameStats.versionOfGame = versionOfGame;
    }
}
