package com.chat360.assignment.controller;

import com.chat360.assignment.interfaces.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/add")
    double add(@RequestParam double num1, @RequestParam double num2){
        return calculatorService.add(num1,num2);
    };

    @GetMapping("/subtract")
    double subtract(@RequestParam double num1, @RequestParam double num2){
        return calculatorService.subtract(num1,num2);
    };

    @GetMapping("/multiply")
    double multiply(@RequestParam double num1, @RequestParam double num2){
        return calculatorService.multiply(num1,num2);
    };

    @GetMapping("/divide")
    double divide(@RequestParam double num1, @RequestParam double num2){
        return calculatorService.divide(num1,num2);
    };
}

