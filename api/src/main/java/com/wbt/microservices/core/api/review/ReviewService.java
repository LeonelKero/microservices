package com.wbt.microservices.core.api.review;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ReviewService {
    @GetMapping(path = {"/reviews/reviewId"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    Review getReview(final @PathVariable Long reviewId);
}
