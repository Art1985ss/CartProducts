package com.art.database;

import com.art.entities.Product;

import java.util.NoSuchElementException;

public class ProductRepository extends Repository<Product> {
    private static final String EXCEPTION_MESSAGE = "Mo product with id %d exists in database!";

    @Override
    public boolean save(Product product) {
        if (set.contains(product)) {
            return this.update(product);
        }
        return set.add(new Product(count.getAndIncrement(), product));
    }

    @Override
    public boolean update(Product product) throws NoSuchElementException {
        Product product1 = getById(product.getId());
        if (product1 == null) {
            throw new NoSuchElementException(String.format(EXCEPTION_MESSAGE, product.getId()));
        }
        set.remove(product1);
        return set.add(product);
    }

    @Override
    public Product getById(long id) throws NoSuchElementException {
        return set.stream()
                .filter(product -> product.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format(EXCEPTION_MESSAGE, id)));
    }
}
