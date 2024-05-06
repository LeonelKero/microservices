package com.wbt.microservices.core.api.composite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductCompositeService {
    @GetMapping(path = {"/product-composite/{id}"}, produces = {"application/json"})
    ProductAggregate getProduct(final @PathVariable(name = "id") Long productId);

}
