package com.codegym.ss3_thymeleaf.repository;

import com.codegym.ss3_thymeleaf.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iPhone 14", "Flagship iOS", "Apple", 1000));
        productList.add(new Product(2, "Galaxy S22", "Flagship Android", "Samsung", 900));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    @Override
    public Product findById(int id) {
        return productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Product product) {
        int newId = productList.size() > 0
                ? productList.get(productList.size() - 1).getId() + 1
                : 1;
        product.setId(newId);
        productList.add(product);
    }

    @Override
    public void update(int id, Product updatedProduct) {
        Optional<Product> optionalProduct = Optional.ofNullable(findById(id));
        optionalProduct.ifPresent(existing -> {
            existing.setName(updatedProduct.getName());
            existing.setDescription(updatedProduct.getDescription());
            existing.setPrice(updatedProduct.getPrice());
            existing.setManufacturer(updatedProduct.getManufacturer());
        });
    }


    @Override
    public void delete(int id) {
        productList.removeIf(p -> p.getId() == id);
    }

    @Override
    public List<Product> searchByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return productList;
        }
        String[] keywords = name.trim().toLowerCase().split("\\s+");
        return productList.stream()
                .filter(p -> {
                    String productName = p.getName().toLowerCase();
                    return Arrays.stream(keywords).allMatch(productName::contains);
                })
                .collect(Collectors.toList());
    }

}
