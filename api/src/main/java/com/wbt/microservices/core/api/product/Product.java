package com.wbt.microservices.core.api.product;

public record Product(Long productId, String name, Double weight, String serviceAddress) {
}
