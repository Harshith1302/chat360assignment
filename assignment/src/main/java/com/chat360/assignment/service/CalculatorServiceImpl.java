package com.chat360.assignment.service;

import com.chat360.assignment.enums.LogLevel;
import com.chat360.assignment.interfaces.CalculatorService;
import com.chat360.assignment.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Autowired
    private LogIngestor logIngestor;

    @Override
    public double add(double num1, double num2) {
        logIngestor.log(new Log(LogLevel.INFO,"Successfully added the numbers "+num1+" "+num2,"Calculator Service"));
        return num1 + num2;
    }

    @Override
    public double subtract(double num1, double num2) {
        logIngestor.log(new Log(LogLevel.INFO,"Successfully subtracted the numbers "+num1+" "+num2,"Calculator Service"));
        return num1 - num2;
    }

    @Override
    public double multiply(double num1, double num2) {
        logIngestor.log(new Log(LogLevel.INFO,"Successfully multiplied the numbers "+num1+" "+num2,"Calculator Service"));
        return num1 * num2;
    }

    @Override
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            logIngestor.log(new Log(LogLevel.ERROR,"Division by zero not possible please change the number","Calculator Service"));
            throw new IllegalArgumentException("Division by zero not possible please change the number");
        }
        logIngestor.log(new Log(LogLevel.INFO,"Successfully divide the number "+num2+" from "+num1,"Calculator Service"));
        return num1 / num2;
    }
}

