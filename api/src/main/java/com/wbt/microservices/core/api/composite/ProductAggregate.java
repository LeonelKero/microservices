package com.wbt.microservices.core.api.composite;

import com.wbt.microservices.core.api.review.Review;

import java.util.List;

public record ProductAggregate(
        Long productId,
        String name,
        Double weight,
        List<RecommendationSummary> recommendations,
        List<Review> reviews,
        ServiceAddresses serviceAddresses
) {
}
