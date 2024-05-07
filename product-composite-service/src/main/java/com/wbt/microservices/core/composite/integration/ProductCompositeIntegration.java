package com.wbt.microservices.core.composite.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wbt.microservices.core.api.product.Product;
import com.wbt.microservices.core.api.product.ProductService;
import com.wbt.microservices.core.api.recommendation.Recommendation;
import com.wbt.microservices.core.api.recommendation.RecommendationService;
import com.wbt.microservices.core.api.review.Review;
import com.wbt.microservices.core.api.review.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductCompositeIntegration implements ProductService, ReviewService, RecommendationService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String reviewServiceUrl;

    public ProductCompositeIntegration(
            RestTemplate restTemplate,
            ObjectMapper objectMapper,

            @Value("${app.product-service.host}")
            String productServiceUrl,
            @Value("${app.product-service.port}")
            Long psPort,

            @Value("${app.recommendation-service.host}")
            String recommendationServiceUrl,
            @Value("${app.recommendation-service.port}")
            Long rcPort,

            @Value("${app.review-service.host}")
            String reviewServiceUrl,
            @Value("${app.review-service.port}")
            Long rsPort) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.productServiceUrl = "http://" + productServiceUrl + ":" + psPort + "/products";
        this.recommendationServiceUrl = "http://" + recommendationServiceUrl + ":" + rcPort + "/recommendations";
        this.reviewServiceUrl = "http://" + reviewServiceUrl + ":" + rsPort + "/reviews";
    }

    @Override
    public Product getProduct(Long productId) {
        return null;
    }

    @Override
    public Recommendation getRecommendation(Long recommendationId) {
        return null;
    }

    @Override
    public Review getReview(Long reviewId) {
        return null;
    }
}
