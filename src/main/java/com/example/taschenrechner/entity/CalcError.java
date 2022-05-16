package com.example.taschenrechner.entity;

public class CalcError {

    private final String message;

    public CalcError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
