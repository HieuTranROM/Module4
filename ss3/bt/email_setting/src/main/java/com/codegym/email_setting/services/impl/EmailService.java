package com.codegym.email_setting.services.impl;

import com.codegym.email_setting.models.Email;
import com.codegym.email_setting.repositories.IEmailRepository;
import com.codegym.email_setting.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private IEmailRepository emailRepository;
    @Override
    public void save(Email email) {
            emailRepository.save(email);
    }
}
