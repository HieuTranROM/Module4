package com.codegym.ung_dung_muon_sach.repository;

import com.codegym.ung_dung_muon_sach.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT count(b) from Book b")
    int countBooks();
}
