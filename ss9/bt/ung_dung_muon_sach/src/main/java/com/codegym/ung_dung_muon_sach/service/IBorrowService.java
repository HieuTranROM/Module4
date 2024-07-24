package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.entity.Borrow;

public interface IBorrowService extends Service<Borrow> {
    boolean checkBorrowed(int id);
    boolean doReturnBook(int id);


}
