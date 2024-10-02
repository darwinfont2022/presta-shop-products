package com.darwinfont.presta_products.service;

import com.darwinfont.presta_products.domain.request.ProductRequest;
import com.darwinfont.presta_products.domain.response.PrestaProductRes;
import com.darwinfont.presta_products.domain.response.ProductListResponse;
import com.darwinfont.presta_products.domain.response.ProductResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {
    Mono<ProductResponse> createProduct(ProductRequest productDto);
    Mono<PrestaProductRes> getProductById(Integer product_id);
    Mono<ProductResponse> updateProduct(Integer productId, ProductRequest productReqDto);
    Mono<?> deleteProduct(Integer productId);

    Mono<ProductListResponse> loadProducts(
            Integer page, Integer limit,
            Integer category_id,
            List<String> reference,
            List<Integer> ids
    );
}