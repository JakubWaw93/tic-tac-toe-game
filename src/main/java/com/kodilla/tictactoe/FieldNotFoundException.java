package com.kodilla.tictactoe;

import java.io.Serial;

public class FieldNotFoundException extends Exception {

    public FieldNotFoundException(String message) {
        super(message);
    }

    @Serial
    private static final long serialVersionUID = 3752414687078418840L;
}
