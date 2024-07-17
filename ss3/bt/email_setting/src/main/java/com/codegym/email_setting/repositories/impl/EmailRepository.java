package com.codegym.email_setting.repositories.impl;


import com.codegym.email_setting.models.Email;
import com.codegym.email_setting.repositories.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {

    private static List<Email> emails = new ArrayList<>();

    @Override
    public void save(Email email) {
            emails.add(email);
    }

}
