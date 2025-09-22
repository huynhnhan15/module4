package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.Book;
import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Long id);
    String borrowBook(Long id);
    void returnBook(String code);
}