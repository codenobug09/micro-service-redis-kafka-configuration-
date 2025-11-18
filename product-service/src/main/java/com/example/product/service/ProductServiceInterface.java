package com.example.product.service;

import com.example.product.model.Product;

public interface ProductServiceInterface{
    Product getById(Long id);

    Product create(Product p);

    Product update(Product p, Long id);

    void delete(Long id);
}
