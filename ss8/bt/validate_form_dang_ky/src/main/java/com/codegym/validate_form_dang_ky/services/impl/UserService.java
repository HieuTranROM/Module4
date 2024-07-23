package com.codegym.validate_form_dang_ky.services.impl;

import com.codegym.validate_form_dang_ky.models.User;
import com.codegym.validate_form_dang_ky.repositories.IUserRepository;
import com.codegym.validate_form_dang_ky.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
