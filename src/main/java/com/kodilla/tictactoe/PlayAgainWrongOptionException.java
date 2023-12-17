package com.kodilla.tictactoe;

import java.io.Serial;

public class PlayAgainWrongOptionException extends Exception {

    public PlayAgainWrongOptionException(String message){
        super(message);
    }

    @Serial
    private static final long serialVersionUID = 5470160635230242196L;
}
