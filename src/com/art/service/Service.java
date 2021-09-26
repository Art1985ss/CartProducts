package com.art.service;

import com.art.entities.Cart;
import com.art.entities.Product;

import java.util.List;
import java.util.Set;

public class Service implements Capabilities {
    private final ProductService productService;
    private final CartService cartService;

    public Service(ProductService productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @Override
    public Set<Product> getAllProducts() {
        return productService.getAll();
    }

    @Override
    public List<Product> getCartProducts(Cart cart) {
        return cart.getProducts();
    }

    @Override
    public Cart addProductToCart(Cart cart, Product product) {
        List<Product> products = cart.getProducts();
        products.add(product);
        Cart newCart = new Cart(cart.getId(), products);
        if (cartService.update(newCart)) {
            return newCart;
        }
        return cart;
    }
}
