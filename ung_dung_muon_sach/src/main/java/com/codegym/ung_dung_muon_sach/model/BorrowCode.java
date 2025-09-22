package com.codegym.ung_dung_muon_sach.model;

import jakarta.persistence.*;

@Entity
public class BorrowCode {
    @Id
    private String code;

    @ManyToOne
    private Book book;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
}
