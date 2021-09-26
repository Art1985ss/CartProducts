package com.art.service;

import com.art.entities.Cart;
import com.art.entities.Product;

import java.util.List;
import java.util.Set;

public interface Capabilities {
    Set<Product> getAllProducts();
    List<Product> getCartProducts(Cart cart);
    Cart addProductToCart(Cart cart, Product product);
}
