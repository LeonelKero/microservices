package com.wbt.microservices.core.api.product;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {

    @GetMapping(path = {"/products/{productId}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    Product getProduct(final @PathVariable Long productId);

}
