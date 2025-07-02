package com.codegym.flowershop.repository;


import com.codegym.flowershop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}