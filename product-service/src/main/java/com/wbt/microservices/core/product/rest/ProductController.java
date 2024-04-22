package com.wbt.microservices.core.product.rest;

import com.wbt.microservices.core.api.product.Product;
import com.wbt.microservices.core.api.product.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductService {
    @Override
    public Product getProduct(final Long productId) {
        return new Product(1L, "Macbook Pro 16", 2.5, "Douala Cameroon");
    }
}
