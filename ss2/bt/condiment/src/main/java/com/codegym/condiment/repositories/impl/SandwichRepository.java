package com.codegym.condiment.repositories.impl;
import com.codegym.condiment.repositories.ISandwichRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SandwichRepository implements ISandwichRepository {


    @Override
    public String[] getAll() {
        return new String[] {"Lettuce", "Tomato", "Mustard", "Sprouts"};
    }
}
