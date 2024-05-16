package com.wbt.microservices.core.api.review;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReviewService {
    @GetMapping(path = {"/reviews/reviewId"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    Review getReview(final @PathVariable Long reviewId);

    @GetMapping(path = {"/reviews"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    List<Review> getReviewsForProduct(final @RequestParam(name = "productId") Long productId);
}
