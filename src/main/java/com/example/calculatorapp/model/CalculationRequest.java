package com.example.calculatorapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CalculationRequest {
    @NotNull(message = "Operand1 cannot be null")
    private Double operand1;

    @NotNull(message = "Operand2 cannot be null")
    private Double operand2;

    @NotNull(message = "Operation cannot be null")
    private String operation; //+,-,*，/
}
