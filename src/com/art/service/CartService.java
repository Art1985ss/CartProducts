package com.art.service;

import com.art.Crud;
import com.art.database.CartRepository;
import com.art.entities.Cart;
import java.util.NoSuchElementException;
import java.util.Set;

public class CartService implements Crud<Cart> {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Set<Cart> getAll() {
        return cartRepository.getAll();
    }

    @Override
    public boolean save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public boolean update(Cart cart) throws NoSuchElementException {
        return cartRepository.update(cart);
    }

    @Override
    public Cart getById(long id) throws NoSuchElementException {
        return cartRepository.getById(id);
    }

    @Override
    public boolean remove(Cart cart) {
        return cartRepository.remove(cart);
    }

}
