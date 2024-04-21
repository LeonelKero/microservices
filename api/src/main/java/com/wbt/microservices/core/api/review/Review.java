package com.wbt.microservices.core.api.review;

public record Review(Long reviewId, Long productId, String author, String subject, String content) {
}
