package com.kodilla.tictactoe;
import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

import static com.kodilla.tictactoe.GameStats.*;

public class GameMechanics {

    PlayerChoicesImplementation playerChoicesImplementation  = new PlayerChoicesImplementation();

    public void multiGameLoop() {
        while (!GameStats.isTotalEnd()) {
            while (!GameStats.isEnd()) {
                GameStats.setRound(GameStats.getRound()+1);
                setNewArray();
                GameStats.setTurnOfPlayer(1);
                Console.showInstructions();
                singleGameLoop();
                Console.showWinner();
                addingPoint();
                Console.showPoints();
            }
            try {
                playAgainMechanics();
            } catch (PlayAgainWrongOptionException e) {
                Console.exceptionMessage(e.getMessage());
            }
        }

    }

    public void singleGameLoop() {
        while (!GameStats.isEnd()){
            try {
                arrayOfMoves();
            } catch (FieldNotFoundException | NotEmptyFieldException e) {
                Console.exceptionMessage(e.getMessage());
                singleGameLoop();
            }
            Console.updateConsole();
            checkWinner();
            checkForFullMap();
            if (!GameStats.isEnd()) {
                changeTurn();
            }
        }
    }

    public void arrayOfMoves() throws FieldNotFoundException, NotEmptyFieldException {
        Console.whoseTurn();
        if (GameStats.getNumberOfPlayers()==2) {
            playerChoicesImplementation.makeAMove();
        } else if (GameStats.getNumberOfPlayers()==1) {
            if (GameStats.getTurnOfPlayer()==1) {
                playerChoicesImplementation.makeAMove();
            } else if (GameStats.getTurnOfPlayer()==2) {
                computerMove();
            }
        }
    }

    public void computerMove() {
        RandomGenerator random = new Random();
        boolean emptyField = false;
        while (!emptyField){
            if (GameStats.getVersionOfGame()==1) {
                int i = random.nextInt(GameStats.getArrayOfFields().length);
                int j = random.nextInt(GameStats.getArrayOfFields().length);
                if (GameStats.getArrayOfFields()[i][j] == 0) {
                    GameStats.getArrayOfFields()[i][j] = GameStats.getTurnOfPlayer();
                    emptyField = true;
                }
            } else if (GameStats.getVersionOfGame()==2) {
                int i = random.nextInt(GameStats.getBiggerArrayOfFields().length);
                int j = random.nextInt(GameStats.getBiggerArrayOfFields().length);
                if (GameStats.getBiggerArrayOfFields()[i][j] == 0) {
                    GameStats.getBiggerArrayOfFields()[i][j] = GameStats.getTurnOfPlayer();
                    emptyField = true;
                }
            }
        }
    }

    public void checkWinner() {
        if (GameStats.getVersionOfGame() == 1) {
            GameStats.setWinnerPlayer(checkForVictory(getArrayOfFields()));
        } else {
            GameStats.setWinnerPlayer(checkForVictory(getBiggerArrayOfFields()));
        }
    }

    public void addingPoint() {
        if (GameStats.isEnd()){
            if (GameStats.getWinnerPlayer()==1) {
                GameStats.setPlayer1Points(GameStats.getPlayer1Points()+1);
            } else if (GameStats.getWinnerPlayer() == 2) {
                GameStats.setPlayer2Points(GameStats.getPlayer2Points()+1);
            }
        }
    }

    public int checkForVictory(int[][] arrayOfFields) {
        if (arrayOfFields.length > 2 && arrayOfFields.length < 10) {
            int conversionFactor = arrayOfFields.length - 2;

            for (int k = 0; k < conversionFactor; k++) {
                for (int l = 0; l < conversionFactor; l++) {
                    for (int i = 0; i < 3; i++) {
                        if (arrayOfFields[i + k][0 + l] == arrayOfFields[i + k][1 + l] && arrayOfFields[i + k][1 + l] == arrayOfFields[i + k][2 + l] && arrayOfFields[i + k][2 + l] != 0) {
                            GameStats.setEnd(true);
                            return GameStats.getTurnOfPlayer();
                        }
                    }
                    for (int j = 0; j < 3; j++) {
                        if (arrayOfFields[0 + k][j + l] == arrayOfFields[1 + k][j + l] && arrayOfFields[1 + k][j + l] == arrayOfFields[2 + k][j + l] && arrayOfFields[2 + k][j] != 0) {
                            GameStats.setEnd(true);
                            return GameStats.getTurnOfPlayer();
                        }
                    }
                    if (arrayOfFields[0 + k][0 + l] == arrayOfFields[1 + k][1 + l] && arrayOfFields[1 + k][1 + l] == arrayOfFields[2 + k][2 + l] && arrayOfFields[2 + k][2 + l] != 0) {
                        GameStats.setEnd(true);
                        return GameStats.getTurnOfPlayer();
                    } else if (arrayOfFields[2 + k][ + l] == arrayOfFields[1 + k][1 + l] && arrayOfFields[1 + k][1 + l] == arrayOfFields[0 + k][2 + l] && arrayOfFields[0 + k][2 + l] != 0) {
                        GameStats.setEnd(true);
                        return GameStats.getTurnOfPlayer();
                    }
                }
            }
        } else if (arrayOfFields.length >= 10) {
            int conversionFactor = arrayOfFields.length - 4;

            for (int k = 0; k < conversionFactor; k++) {
                for (int l = 0; l < conversionFactor; l++) {
                    for (int i = 0; i < 5; i++) {
                        if (arrayOfFields[i + k][0 + l] == arrayOfFields[i + k][1 + l] && arrayOfFields[i + k][1 + l] == arrayOfFields[i + k][2 + l] && arrayOfFields[i + k][2 + l] == arrayOfFields[i + k][3 + l] && arrayOfFields[i + k][3 + l] == arrayOfFields[i + k][4 + l] && arrayOfFields[i + k][4 + l] != 0) {
                            GameStats.setEnd(true);
                            return GameStats.getTurnOfPlayer();
                        }
                    }
                    for (int j = 0; j < 5; j++) {
                        if (arrayOfFields[0 + k][j + l] == arrayOfFields[1 + k][j + l] && arrayOfFields[1 + k][j + l] == arrayOfFields[2 + k][j + l] && arrayOfFields[2 + k][j + l] == arrayOfFields[3 + k][j + l] && arrayOfFields[3 + k][j + l] == arrayOfFields[4 + k][j + l] && arrayOfFields[4 + k][j + l] != 0) {
                            GameStats.setEnd(true);
                            return GameStats.getTurnOfPlayer();
                        }
                    }
                    if (arrayOfFields[0 + k][0 + l] == arrayOfFields[1 + k][1 + l] && arrayOfFields[1 + k][1 + l] == arrayOfFields[2 + k][2 + l] && arrayOfFields[2 + k][2 + l] == arrayOfFields[3 + k][3 + l] && arrayOfFields[3 + k][3 + l] == arrayOfFields[4 + k][4 + l] && arrayOfFields[4 + k][4 + l] != 0) {
                        GameStats.setEnd(true);
                        return GameStats.getTurnOfPlayer();
                    } else if (arrayOfFields[4 + k][0 + l] == arrayOfFields[3 + k][1 + l] && arrayOfFields[3 + k][1 + l] == arrayOfFields[2 + k][2 + l] && arrayOfFields[2 + k][2 + l] == arrayOfFields[1 + k][3 + l] && arrayOfFields[1 + k][3 + l] == arrayOfFields[0 + k][4 + l] && arrayOfFields[0 + k][4 + l] != 0) {
                        GameStats.setEnd(true);
                        return GameStats.getTurnOfPlayer();
                    }
                }
            }
        }
        return 0;
    }

    public void checkForFullMap() {
        if (GameStats.getVersionOfGame()==1){
            fullMap(GameStats.getArrayOfFields());
        } else if (GameStats.getVersionOfGame()==2) {
            fullMap(GameStats.getBiggerArrayOfFields());
        }
    }

    public boolean fullMap(int[][] arrayOfFields) {
        int min=2;
        for (int[] arrayOfField : arrayOfFields) {
            for (int i : arrayOfField) {
                if (i < min) {
                    min = i;
                }
            }
        }
        if (min > 0) {
            GameStats.setEnd(true);
            return true;
        }
        return false;
    }

    public void changeTurn() {
        if (GameStats.getTurnOfPlayer()==1) {
            GameStats.setTurnOfPlayer(2);
        } else if (GameStats.getTurnOfPlayer()==2) {
            GameStats.setTurnOfPlayer(1);
        }
    }

    public void playAgainMechanics() throws PlayAgainWrongOptionException {
        if (!GameStats.isTotalEnd()) {
            try {
                int playerChoice = Integer.parseInt(Console.playAgain());
                if (playerChoice == 1) {
                    GameStats.setWinnerPlayer(0);
                    GameStats.setEnd(false);
                } else if (playerChoice == 2) {
                    GameStats.setTotalEnd(true);
                } else {
                    throw new PlayAgainWrongOptionException("Press '1' to play again or '2' to end.");
                }
            } catch (NumberFormatException e) {
                Console.numberFormatExceptionMessage();
                playAgainMechanics();
            }
        }
    }

    public void setNewArray() {
        for (int[] arrayOfField : GameStats.getArrayOfFields()) {
            Arrays.fill(arrayOfField, 0);
        }
        for (int[] arrayOfField : GameStats.getBiggerArrayOfFields()) {
            Arrays.fill(arrayOfField, 0);
        }
    }

}