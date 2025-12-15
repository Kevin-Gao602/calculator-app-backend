package com.example.calculatorapp.controller;

import com.example.calculatorapp.model.CalculationRequest;
import com.example.calculatorapp.model.CalculationResponse;
import com.example.calculatorapp.service.CalculatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //标识为REST控制器
@RequestMapping("/api/calculator") //设置基础路径
@CrossOrigin(origins = "*") // 允许跨域请求（方便前端调用）
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<CalculationResponse> calculte(
            @Valid @RequestBody CalculationRequest request
    ) {
        try {
            //调用service执行计算
            Double result = calculatorService.calculate(
                    request.getOperand1(),
                    request.getOperand2(),
                    request.getOperation()
            );
            //返回成功响应
            return ResponseEntity.ok(CalculationResponse.success(result));

        } catch (Exception e) {
            //返回错误响应
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(CalculationResponse.error(e.getMessage()));
        }
    }
}
