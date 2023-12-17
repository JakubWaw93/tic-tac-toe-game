package com.kodilla.tictactoe;

import java.io.Serial;

public class InvalidNumberOfPlayersException extends Exception {

    public InvalidNumberOfPlayersException(String message){
        super(message);
    }

    @Serial
    private static final long serialVersionUID = 4929216263711342645L;
}
