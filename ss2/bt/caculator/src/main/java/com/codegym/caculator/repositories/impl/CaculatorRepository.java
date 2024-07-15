package com.codegym.caculator.repositories.impl;

import com.codegym.caculator.repositories.ICaculatorRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CaculatorRepository implements ICaculatorRepository {
    @Override
    public double caculator(double firstNumber, double secondNumber, String item) {
        switch (item){
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
               if(firstNumber != 0 || secondNumber != 0){
                   return firstNumber / secondNumber;
               }else {
                   throw new IllegalArgumentException("The first number and the second number cannot be zero");
               }
            default:
                throw new IllegalArgumentException("The item is not valid");
        }
    }
}
