package com.example.taschenrechner;

import com.example.taschenrechner.entity.CalcError;
import com.example.taschenrechner.entity.CalcRequest;
import com.example.taschenrechner.entity.CalcResult;
import com.example.taschenrechner.service.Operation;
import com.example.taschenrechner.service.OperationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @Autowired
    private OperationFactory operationFactory;

    Logger logger = LoggerFactory.getLogger(CalcController.class);

    @GetMapping("/")
    public String mainPage() {
        return "CALCULATOR APP";
    }

    @GetMapping("/compute")
    public ResponseEntity<?> computeGet(@RequestParam String op, @RequestParam String operand1, @RequestParam String operand2) {
        logger.info("Received a GET request: operand1={}, operand2={}, operation={}", operand1, operand2, op);
        Operation operation = operationFactory.getOperation(op);
        CalcResult resource = new CalcResult(operation.compute(Double.parseDouble(operand1), Double.parseDouble(operand2)));
        logger.info("Sending a response: result={}", resource.getResult());
        return ResponseEntity.ok(resource);
    }

    @PostMapping("/compute")
    public ResponseEntity<?> computePost(@RequestBody CalcRequest calcRequest) {
        logger.info("Received a POST request: operand1={}, operand2={}, operation={}", calcRequest.getOperand1(), calcRequest.getOperand2(), calcRequest.getOp());
        Operation operation = operationFactory.getOperation(calcRequest.getOp());
        double operand1 = Double.parseDouble(calcRequest.getOperand1());
        double operand2 = Double.parseDouble(calcRequest.getOperand2());
        CalcResult resource = new CalcResult(operation.compute(operand1, operand2));
        logger.info("Sending a response: result={}", resource.getResult());
        return ResponseEntity.ok(resource);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleOperationException(IllegalArgumentException exception) {
        logger.error(exception.getMessage());
        CalcError resource = new CalcError("ERROR: " + exception.getMessage());
        return ResponseEntity.badRequest().body(resource);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> handleNumberException() {
        logger.error("Input number(s) could not be parsed");
        CalcError resource = new CalcError("ERROR: Invalid input numbers");
        return ResponseEntity.badRequest().body(resource);
    }

}
