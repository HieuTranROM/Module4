package com.codegym.validate_thong_tin_bai_hat.services.impl;

import com.codegym.validate_thong_tin_bai_hat.models.Song;
import com.codegym.validate_thong_tin_bai_hat.repositories.ISongRepository;
import com.codegym.validate_thong_tin_bai_hat.services.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }
}
