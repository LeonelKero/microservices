package com.wbt.microservices.core.product.rest;

import com.wbt.microservices.core.api.product.Product;
import com.wbt.microservices.core.api.product.ProductService;
import com.wbt.microservices.core.util.ServiceUtil;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController implements ProductService {

//    private final ServiceUtil serviceUtil;
//
//    public ProductController(ServiceUtil serviceUtil) {
//        this.serviceUtil = serviceUtil;
//    }

    @Override
    public Product getProduct(final Long productId) {
        return new Product(1L, "Macbook Pro 16", 2.5, "serviceUtil.getServiceAddress()");
    }
}
