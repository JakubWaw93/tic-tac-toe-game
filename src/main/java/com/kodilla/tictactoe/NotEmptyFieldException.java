package com.kodilla.tictactoe;

import java.io.Serial;

public class NotEmptyFieldException extends Exception {

    public NotEmptyFieldException(String message){
        super(message);
    }

    @Serial
    private static final long serialVersionUID = 5728539023087023131L;
}
