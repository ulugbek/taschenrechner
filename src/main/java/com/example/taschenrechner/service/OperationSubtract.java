package com.example.taschenrechner.service;

public class OperationSubtract implements Operation {

    @Override
    public double compute(double operand1, double operand2) {
        return operand1 - operand2;
    }

}
