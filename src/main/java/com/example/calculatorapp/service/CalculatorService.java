package com.example.calculatorapp.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Double calculate(Double operand1, Double operand2, String operation) {

        if (operand1 == null || operand2 == null || operation == null) {
            throw new RuntimeException("Operands or Operation cannot be null");
        }

        return switch (operation) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new RuntimeException("Cannot divide by zero");
                }
                yield operand1 / operand2;
            }
            default -> throw new RuntimeException("Invalid operation");
        };
    }
    public Double calculateSingle(Double operand, String operation) {
        if (operand == null || operation == null) {
            throw new RuntimeException("Operand or Operation cannot be null");
        }

        return switch (operation) {
            case "reciprocal" -> {  // 1/x
                if (operand == 0) {
                    throw new RuntimeException("Cannot divide by zero");
                }
                yield 1.0 / operand;
            }
            case "square" -> operand * operand;  // x²
            case "sqrt" -> {  // ²√x
                if (operand < 0) {
                    throw new RuntimeException("Cannot calculate square root of negative number");
                }
                yield Math.sqrt(operand);
            }
            case "percent" -> operand / 100.0;  // %
            case "negate" -> -operand;  // +/−
            default -> throw new RuntimeException("Invalid single operation: " + operation);
        };
    }
}
