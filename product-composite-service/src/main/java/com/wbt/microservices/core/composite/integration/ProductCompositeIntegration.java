package com.wbt.microservices.core.composite.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wbt.microservices.core.api.product.Product;
import com.wbt.microservices.core.api.product.ProductService;
import com.wbt.microservices.core.api.recommendation.Recommendation;
import com.wbt.microservices.core.api.recommendation.RecommendationService;
import com.wbt.microservices.core.api.review.Review;
import com.wbt.microservices.core.api.review.ReviewService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProductCompositeIntegration implements ProductService, ReviewService, RecommendationService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String productServiceUrl;
    private final String recommendationServiceUrl;
    private final String baseRecommendationServiceUrl;
    private final String reviewServiceUrl;
    private final String baseReviewServiceUrl;

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
        this.recommendationServiceUrl = "http://" + recommendationServiceUrl + ":" + rcPort + "/recommendations?productId=";
        this.baseRecommendationServiceUrl = "http://" + recommendationServiceUrl + ":" + rcPort + "/recommendations";
        this.reviewServiceUrl = "http://" + reviewServiceUrl + ":" + rsPort + "/reviews?productId=";
        this.baseReviewServiceUrl = "http://" + reviewServiceUrl + ":" + rsPort + "/reviews";
    }

    @Override
    public Product getProduct(final Long productId) {
        final var url = this.productServiceUrl.concat("/" + productId);
        return this.restTemplate.getForObject(url, Product.class);
    }

    @Override
    public Recommendation getRecommendation(final Long recommendationId) {
        return this.restTemplate.exchange(
                this.baseRecommendationServiceUrl + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Recommendation>() {
                },
                recommendationId
        ).getBody();
    }

    @Override
    public List<Recommendation> getRecommendationsForProduct(final Long productId) {
        final var productRecommendationsUrl = this.recommendationServiceUrl + productId;
        return this.restTemplate.exchange(
                productRecommendationsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Recommendation>>() {
                }).getBody();
    }

    @Override
    public Review getReview(final Long reviewId) {
        return this.restTemplate.exchange(
                this.baseReviewServiceUrl + "/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Review>() {
                },
                reviewId
        ).getBody();
    }

    @Override
    public List<Review> getReviewsForProduct(final Long productId) {
        return this.restTemplate.exchange(
                this.reviewServiceUrl + productId,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Review>>() {
                }
        ).getBody();
    }
}
