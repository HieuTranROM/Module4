package com.codegym.validate_form_dang_ky.services;

import com.codegym.validate_form_dang_ky.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
