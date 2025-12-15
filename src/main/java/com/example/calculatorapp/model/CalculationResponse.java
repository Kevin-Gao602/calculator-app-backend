package com.example.calculatorapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculationResponse {

    private Double result;

    private String message;

    private Boolean success;

    //创建成功响应
    public static CalculationResponse success(Double result){
        return new CalculationResponse(result, "success", true);
    }

    //创建错误响应
    public static CalculationResponse error(String message){
        return new CalculationResponse(null, message, false);
    }

}
