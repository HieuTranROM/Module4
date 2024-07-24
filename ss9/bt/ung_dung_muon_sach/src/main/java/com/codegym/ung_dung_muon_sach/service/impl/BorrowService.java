package com.codegym.ung_dung_muon_sach.service.impl;

import com.codegym.ung_dung_muon_sach.entity.Book;
import com.codegym.ung_dung_muon_sach.entity.Borrow;
import com.codegym.ung_dung_muon_sach.repository.BorrowRepository;
import com.codegym.ung_dung_muon_sach.service.IBookService;
import com.codegym.ung_dung_muon_sach.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private BorrowRepository repository;
    @Autowired
    private IBookService bookService;

    @Override
    public boolean create(Borrow borrow) {
        Book book = new Book();
        book = bookService.findById(borrow.getBook().getId());
        int newQuantity = book.getQuantity();
        if (newQuantity == 0) {
            return false;
        }
        book.setQuantity(book.getQuantity() - 1);
        repository.save(borrow);
        return true;
    }


    @Override
    public boolean delete(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Borrow findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Borrow> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean checkBorrowed(int id) {
        for (Borrow br : repository.findAll()) {
            if (br.getCodeBorrow() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean doReturnBook(int id) {
        for (Borrow br : repository.findAll()) {
            if (br.getCodeBorrow()==id) {
                br.getBook().setQuantity(br.getBook().getQuantity() + 1);
                repository.deleteById(id);
                return true;
            }
        }
        return false;
    }

}
