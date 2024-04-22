package com.wbt.microservices.core.recommendation.rest;

import com.wbt.microservices.core.api.recommendation.Recommendation;
import com.wbt.microservices.core.api.recommendation.RecommendationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationController implements RecommendationService {
    @Override
    public Recommendation getRecommendation(Long recommendationId) {
        return new Recommendation(1L, 1L, "leonel ka", 4.5, "Very good product for child");
    }
}
