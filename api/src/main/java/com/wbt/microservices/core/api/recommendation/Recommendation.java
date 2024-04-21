package com.wbt.microservices.core.api.recommendation;

public record Recommendation(Long recommendationId, Long productId, String author, Double rate, String content) {
}
