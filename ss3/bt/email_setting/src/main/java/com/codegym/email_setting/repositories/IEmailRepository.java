package com.codegym.email_setting.repositories;

import com.codegym.email_setting.models.Email;

public interface IEmailRepository {
    void save(Email email);
}
