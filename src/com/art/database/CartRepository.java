package com.art.database;

import com.art.entities.Cart;

import java.util.NoSuchElementException;

public class CartRepository extends Repository<Cart> {
    private static final String EXCEPTION_MESSAGE = "No cart with id %d exists in database!";


    @Override
    public boolean save(Cart cart) {
        if (set.contains(cart)) {
            return this.update(cart);
        }
        return set.add(new Cart(count.getAndIncrement(), cart));
    }

    @Override
    public boolean update(Cart cart) throws NoSuchElementException {
        Cart cart1 = getById(cart.getId());
        if (cart1 == null) {
            throw new NoSuchElementException(String.format(EXCEPTION_MESSAGE, cart.getId()));
        }
        set.remove(cart1);
        return set.add(cart);
    }

    @Override
    public Cart getById(long id) throws NoSuchElementException {
        return set.stream()
                .filter(cart -> cart.getId() == id)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException(String.format(EXCEPTION_MESSAGE, id)));
    }
}
