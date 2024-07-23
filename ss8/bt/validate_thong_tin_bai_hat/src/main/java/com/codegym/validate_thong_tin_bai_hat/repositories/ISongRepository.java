package com.codegym.validate_thong_tin_bai_hat.repositories;

import com.codegym.validate_thong_tin_bai_hat.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Long> {
}
