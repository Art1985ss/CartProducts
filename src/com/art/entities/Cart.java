package com.art.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {
    private final long id;
    private final List<Product> products;

    public Cart() {
        this(0);
    }

    public Cart(long id) {
        this.id = id;
        this.products = new ArrayList<>();
    }

    public Cart(List<Product> products) {
        this(0, products);
    }

    public Cart(long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Cart(long id, Cart cart) {
        this.id = id;
        this.products = cart.getProducts();
    }

    public long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }
}
