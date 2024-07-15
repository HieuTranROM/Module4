package com.codegym.condiment.services.impl;

import com.codegym.condiment.repositories.ISandwichRepository;
import com.codegym.condiment.services.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService {
    @Autowired
    private ISandwichRepository sandwichRepo;

    @Override
    public String[] getAll() {
        return sandwichRepo.getAll();
    }
}