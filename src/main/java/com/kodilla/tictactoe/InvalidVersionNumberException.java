package com.kodilla.tictactoe;

import java.io.Serial;

public class InvalidVersionNumberException extends Exception {

    public InvalidVersionNumberException(String message){
        super(message);
    }

    @Serial
    private static final long serialVersionUID = 4591923457686902688L;
}
