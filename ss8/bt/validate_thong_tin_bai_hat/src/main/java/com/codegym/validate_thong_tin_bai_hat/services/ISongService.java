package com.codegym.validate_thong_tin_bai_hat.services;

import com.codegym.validate_thong_tin_bai_hat.models.Song;

import java.util.List;

public interface ISongService {
    void save(Song song);

    List<Song> findAll();

    Song findById(Long id);
}
