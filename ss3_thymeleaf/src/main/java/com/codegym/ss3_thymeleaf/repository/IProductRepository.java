package com.codegym.ss3_thymeleaf.repository;

import com.codegym.ss3_thymeleaf.model.Product;
import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
    List<Product> searchByName(String name);
}
