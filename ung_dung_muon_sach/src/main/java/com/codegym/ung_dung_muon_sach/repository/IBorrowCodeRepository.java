package com.codegym.ung_dung_muon_sach.repository;

import com.codegym.ung_dung_muon_sach.model.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode, String> {}