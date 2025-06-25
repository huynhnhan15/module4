package com.codegym.ung_dung_muon_sach.repository;

import com.codegym.ung_dung_muon_sach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {}