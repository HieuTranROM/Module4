package com.codegym.dictionary.services.impl;

import com.codegym.dictionary.repositories.IDictionaryRepository;
import com.codegym.dictionary.services.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository dictionaryRepository;


    @Override
    public String translate(String word) {
        return dictionaryRepository.translate(word);
    }
}
