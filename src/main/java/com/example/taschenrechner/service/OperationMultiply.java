package com.example.taschenrechner.service;

public class OperationMultiply implements Operation {

    @Override
    public double compute(double operand1, double operand2) {
        return operand1 * operand2;
    }

}
