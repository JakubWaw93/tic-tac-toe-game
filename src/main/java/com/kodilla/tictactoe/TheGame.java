package com.kodilla.tictactoe;
public class TheGame {
    GameMechanics gameMechanics = new GameMechanics();
    PlayerChoicesImplementation playerChoicesImplementation = new PlayerChoicesImplementation();
    GameRanking gameRanking = new GameRanking();


    public void game () {
        if (GameStats.getNumberOfPlayers() == 0) {
            try {
                playerChoicesImplementation.howManyPlayers();
            } catch (InvalidNumberOfPlayersException e) {
                Console.exceptionMessage(e.getMessage());
                game();
            }
        }
        playerChoicesImplementation.player1Name();
        playerChoicesImplementation.player2Name();
        if (GameStats.getVersionOfGame() == 0) {
            try {
                playerChoicesImplementation.whatVersionOfGame();
            } catch (InvalidVersionNumberException e) {
                Console.exceptionMessage(e.getMessage());
                game();
            }
        }
        gameMechanics.multiGameLoop();
        if (GameStats.isEnd()) {
            Console.farewell();
            gameRanking.loadMap();
            gameRanking.saveStats();
            gameRanking.saveMap();
            Console.showRanking();
        }
    }
}