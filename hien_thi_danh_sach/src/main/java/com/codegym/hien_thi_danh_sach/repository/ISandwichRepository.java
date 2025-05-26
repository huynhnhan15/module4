package com.codegym.hien_thi_danh_sach.repository;

import com.codegym.hien_thi_danh_sach.model.Sandwich;

import java.util.List;

public interface ISandwichRepository {
    List<Sandwich> findAll();
}
