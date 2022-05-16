package com.example.taschenrechner.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class OperationFactoryTest {

    @Autowired
    private OperationFactory operationFactory;

    @Test
    void testAddition() {
        Operation operation = operationFactory.getOperation("add");
        Assertions.assertInstanceOf(OperationAdd.class, operation);
        operation = operationFactory.getOperation("Add");
        Assertions.assertInstanceOf(OperationAdd.class, operation);
        operation = operationFactory.getOperation("aDD");
        Assertions.assertInstanceOf(OperationAdd.class, operation);
    }

    @Test
    void testSubtraction() {
        Operation operation = operationFactory.getOperation("subtract");
        Assertions.assertInstanceOf(OperationSubtract.class, operation);
        operation = operationFactory.getOperation("Subtract");
        Assertions.assertInstanceOf(OperationSubtract.class, operation);
        operation = operationFactory.getOperation("SuBtRaCt");
        Assertions.assertInstanceOf(OperationSubtract.class, operation);
    }

    @Test
    void testMultiplication() {
        Operation operation = operationFactory.getOperation("multiply");
        Assertions.assertInstanceOf(OperationMultiply.class, operation);
        operation = operationFactory.getOperation("Multiply");
        Assertions.assertInstanceOf(OperationMultiply.class, operation);
        operation = operationFactory.getOperation("MuLtIpLy");
        Assertions.assertInstanceOf(OperationMultiply.class, operation);
    }

    @Test
    void testDivision() {
        Operation operation = operationFactory.getOperation("divide");
        Assertions.assertInstanceOf(OperationDivide.class, operation);
        operation = operationFactory.getOperation("Divide");
        Assertions.assertInstanceOf(OperationDivide.class, operation);
        operation = operationFactory.getOperation("DiViDe");
        Assertions.assertInstanceOf(OperationDivide.class, operation);
    }

    @Test
    void testEmptyMathOperation() {
        assertThrows(IllegalArgumentException.class, () -> operationFactory.getOperation(null));
        assertThrows(IllegalArgumentException.class, () -> operationFactory.getOperation(""));
        assertThrows(IllegalArgumentException.class, () -> operationFactory.getOperation("    "));
    }

    @Test
    void testInvalidMathOperation() {
        assertThrows(IllegalArgumentException.class, () -> operationFactory.getOperation("null"));
        assertThrows(IllegalArgumentException.class, () -> operationFactory.getOperation("divid"));
        assertThrows(IllegalArgumentException.class, () -> operationFactory.getOperation("addd"));
    }

}
