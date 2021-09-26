package com.art.service;

import com.art.Crud;
import com.art.database.ProductRepository;
import com.art.entities.Product;

import java.util.NoSuchElementException;
import java.util.Set;

public class ProductService implements Crud<Product> {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean update(Product product) throws NoSuchElementException {
        return productRepository.update(product);
    }

    @Override
    public Product getById(long id) throws NoSuchElementException {
        return productRepository.getById(id);
    }

    @Override
    public boolean remove(Product product) {
        return productRepository.remove(product);
    }
}
