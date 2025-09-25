package dev.java.ecommerce.basketservice.service;

import dev.java.ecommerce.basketservice.client.PlatziStoreClient;
import dev.java.ecommerce.basketservice.client.response.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

//    @Cacheable(value = "products")
    @Cacheable(value = "allProducts")
    public List<PlatziProductResponse> getAllProducts() {
        log.info("Getting all products");
        return platziStoreClient.getAllProducts();
    }

//    @Cacheable(value = "products", key = "#productId")
    @Cacheable(value = "productById", key = "#productId")
    public PlatziProductResponse getProductById(Long productId) {
        log.info("Getting product with id: {}", productId);
        return platziStoreClient.getProductById(productId);
    }

//    @Cacheable(value = "products", key = "#productId")
//    public Optional<PlatziProductResponse> getProductById(Long productId) {
//        log.info("Getting product with id: {}", productId);
//        try {
//            return Optional.ofNullable(platziStoreClient.getProductById(productId));
//        } catch (Exception e) {
//            log.warn("Product with id {} not found", productId);
//            return Optional.empty();
//        }
//    }



}
