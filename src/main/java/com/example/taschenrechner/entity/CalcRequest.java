package com.example.taschenrechner.entity;

public class CalcRequest {

    private final String op;
    private final String operand1;
    private final String operand2;

    public CalcRequest(String op, String operand1, String operand2) {
        this.op = op;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public String getOp() {
        return op;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }
}
