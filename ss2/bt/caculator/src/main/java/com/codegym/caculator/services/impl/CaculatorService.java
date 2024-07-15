package com.codegym.caculator.services.impl;

import com.codegym.caculator.repositories.impl.CaculatorRepository;
import com.codegym.caculator.services.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {

    @Autowired
    private CaculatorRepository caculatorRepository;

    @Override
    public double calculate(double firstNumber, double secondNumber, String item) {
        return caculatorRepository.caculator(firstNumber, secondNumber, item);
    }
}
