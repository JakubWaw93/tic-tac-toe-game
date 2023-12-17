package com.kodilla.tictactoe;

public class PlayerChoicesImplementation {

    public void howManyPlayers() throws InvalidNumberOfPlayersException {
        try {
            int players = Integer.parseInt(Console.howManyPlayers());
            if (players == 1 || players == 2) {
                GameStats.setNumberOfPlayers(players);
            } else {
                throw new InvalidNumberOfPlayersException("Choose 1 player to play against computer, \nor 2 players to play with your friend.");
            }
        }catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            howManyPlayers();
        }
    }

    public void player1Name(){
        GameStats.setPlayer1Name(Console.sayYourName1());
    }

    public void player2Name(){
        if (GameStats.getNumberOfPlayers()==2) {
            GameStats.setPlayer2Name(Console.sayYourName2());
        } else {
            GameStats.setPlayer2Name("Computer");
        }
    }

    public void whatVersionOfGame() throws InvalidVersionNumberException {
        try{
            int version = Integer.parseInt(Console.whatVersionOfGame());
            if (version == 1 || version == 2) {
                GameStats.setVersionOfGame(version);
            }else{
                throw new InvalidVersionNumberException("Invalid number of version was chosen.");
            }
        }catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            whatVersionOfGame();
        }
    }

    public void makeAMove() throws FieldNotFoundException, NotEmptyFieldException {
        int [][] gameMap=null;
        if (GameStats.getVersionOfGame()==1) {
            gameMap=GameStats.getArrayOfFields();
        } else if (GameStats.getVersionOfGame()==2) {
            gameMap=GameStats.getBiggerArrayOfFields();
        }
        try {
            int moveI=Integer.parseInt(Console.moveReaderRows())-1;
            int moveJ=Integer.parseInt(Console.moveReaderColumns())-1;
            if (moveI >=0 && moveI <gameMap.length && moveJ >=0 && moveJ <gameMap.length) {
                if (gameMap[moveI][moveJ] == 0) {
                    gameMap[moveI][moveJ] = GameStats.getTurnOfPlayer();
                } else {
                    throw new NotEmptyFieldException("This field is not empty, You must choose empty field");
                }
            }else if (moveI == -1 || moveJ ==-1) {
                GameStats.setEnd(true);
                GameStats.setTotalEnd(true);
            } else {
                throw new FieldNotFoundException("There is no such field!");
            }
        } catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            makeAMove();
        }
    }

}
