package com.codegym.dictionary.repositories.impl;

import com.codegym.dictionary.repositories.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    static private Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("Hello", "Xin chào");
        dictionary.put("Love", "Iu");
        dictionary.put("Name", "Tên");
        dictionary.put("Kill", "Giết");
        dictionary.put("Friday", "Thứ 6");
    }


    @Override
    public String translate(String word) {
        if (dictionary.containsKey(word)) {
            return dictionary.get(word);
        }
        return "Không tìm thấy từ này";
    }
}
