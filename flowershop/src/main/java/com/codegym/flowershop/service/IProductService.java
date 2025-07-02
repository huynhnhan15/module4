package com.codegym.flowershop.service;

import com.codegym.flowershop.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
