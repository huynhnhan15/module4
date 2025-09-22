package com.codegym.ung_dung_muon_sach.service;

import com.codegym.ung_dung_muon_sach.model.Book;
import com.codegym.ung_dung_muon_sach.model.BorrowCode;
import com.codegym.ung_dung_muon_sach.repository.IBookRepository;
import com.codegym.ung_dung_muon_sach.repository.IBorrowCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepo;

    @Autowired
    private IBorrowCodeRepository codeRepo;

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow();
    }

    @Override
    public String borrowBook(Long id) {
        Book book = findById(id);

        if (book.getQuantity() <= 0) {
            throw new BookNotAvailableException("Sách đã hết!");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepo.save(book);

        String code = UUID.randomUUID().toString().replace("-", "").substring(0, 5).toUpperCase();

        BorrowCode borrowCode = new BorrowCode();
        borrowCode.setCode(code);
        borrowCode.setBook(book);
        codeRepo.save(borrowCode);

        return code;
    }

    @Override
    public void returnBook(String code) {
        BorrowCode borrowCode = codeRepo.findById(code)
                .orElseThrow(() -> new InvalidBorrowCodeException("Mã mượn không hợp lệ"));

        Book book = borrowCode.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepo.save(book);
        codeRepo.delete(borrowCode);
    }
}

// Custom Exception viết ngay trong file này
class BookNotAvailableException extends RuntimeException {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class InvalidBorrowCodeException extends RuntimeException {
    public InvalidBorrowCodeException(String message) {
        super(message);
    }
}