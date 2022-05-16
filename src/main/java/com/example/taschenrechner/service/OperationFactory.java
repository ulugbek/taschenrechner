package com.example.taschenrechner.service;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

@Component
public class OperationFactory {

    public Operation getOperation(String operation) {
        if (Strings.isBlank(operation)) {
            throw new IllegalArgumentException("Mathematical operation isn't specified");
        } else if (operation.equalsIgnoreCase("multiply")) {
            return new OperationMultiply();
        } else if (operation.equalsIgnoreCase("divide")) {
            return new OperationDivide();
        } else if (operation.equalsIgnoreCase("add")) {
            return new OperationAdd();
        } else if (operation.equalsIgnoreCase("subtract")) {
            return new OperationSubtract();
        }
        throw new IllegalArgumentException("Unsupported operation: " + operation);
    }

}
