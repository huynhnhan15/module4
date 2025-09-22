package com.codegym.hien_thi_danh_sach.service;

import com.codegym.hien_thi_danh_sach.model.Sandwich;
import com.codegym.hien_thi_danh_sach.repository.ISandwichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SandwichSevice implements ISandwichSevice{

    @Autowired
    private ISandwichRepository sandwichRepository;

    @Override
    public List<Sandwich> findAll() {
        return sandwichRepository.findAll();
    }
}
