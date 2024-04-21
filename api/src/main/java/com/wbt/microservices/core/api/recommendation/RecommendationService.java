package com.wbt.microservices.core.api.recommendation;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface RecommendationService {
    @GetMapping(path = {"/recommendations/{recommendationId}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    Recommendation getRecommendation(final @PathVariable Long recommendationId);
}
