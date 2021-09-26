package com.art;

import com.art.database.CartRepository;
import com.art.database.ProductRepository;
import com.art.entities.Cart;
import com.art.entities.Product;
import com.art.service.CartService;
import com.art.service.ProductService;
import com.art.service.Service;

import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        Product apple = new Product("Apple", new BigDecimal("1.00"));
        Product tv = new Product("TV", new BigDecimal("499.99"));
        Product radio = new Product("Radio", new BigDecimal("99.99"));

        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService(productRepository);
        productService.save(tv);
        productService.save(apple);
        productService.save(radio);

        Cart cart = new Cart();

        CartRepository cartRepository = new CartRepository();
        CartService cartService = new CartService(cartRepository);
        cartService.save(cart);

        Service service = new Service(productService, cartService);

        System.out.println(service.getAllProducts());
        System.out.println(service.getCartProducts(cart));
        System.out.println(service.addProductToCart(cart, apple));
        System.out.println(service.getCartProducts(cart));




    }
}
