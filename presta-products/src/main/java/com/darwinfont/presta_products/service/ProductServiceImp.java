package com.darwinfont.presta_products.service;

import com.darwinfont.presta_products.domain.mapper.ProductMapper;
import com.darwinfont.presta_products.domain.prestaShop.PrestaRootReq;
import com.darwinfont.presta_products.domain.prestaShop.PrestaRootRes;
import com.darwinfont.presta_products.domain.request.ProductRequest;
import com.darwinfont.presta_products.domain.response.PrestaProductRes;
import com.darwinfont.presta_products.domain.response.ProductListResponse;
import com.darwinfont.presta_products.domain.response.ProductResponse;
import com.darwinfont.presta_products.exceptions.BadRequestException;
import com.darwinfont.presta_products.exceptions.BussinessException;
import com.darwinfont.presta_products.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class ProductServiceImp implements ProductService {

    private final WebClient webClient;
    private final WebClient xmlWebClient;
    private final String PRODUCT_URL = "/products";

    public ProductServiceImp(@Qualifier("jsonRequest") WebClient webClient,@Qualifier("xmlRequest") WebClient xmlWebClient) {
        this.webClient = webClient;
        this.xmlWebClient = xmlWebClient;
    }

    @Override
    public Mono<ProductResponse> createProduct(ProductRequest productDto) {
        PrestaRootReq pretaPrestaShopRequest = ProductMapper.createProductXMLRequest(productDto);
        return xmlWebClient.post()
                .uri(uriBuilder ->
                    uriBuilder
                            .path(PRODUCT_URL)
                            .queryParam("output_format", "JSON")
                            .build()
                )
                .body(BodyInserters.fromValue(pretaPrestaShopRequest))
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        return clientResponse.bodyToMono(PrestaRootRes.class)
                                .flatMap(res -> Mono.just(res.getProduct()));
                    }
                    throw new BadRequestException("Invalid product dto");
                });
    }

    @Override
    public Mono<PrestaProductRes> getProductById(Integer product_id) {
        String path = PRODUCT_URL.concat("/{product_id}");
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(path)
                        .queryParam("output_format", "JSON")
                        .build(product_id)
                )
                .retrieve()
                .onStatus(p ->p.value() == HttpStatus.NOT_FOUND.value(), rsp -> Mono.error(new NotFoundException("resource not found")))
                .bodyToMono(PrestaProductRes.class);
    }

    @Override
    public Mono<ProductResponse> updateProduct(Integer productId, ProductRequest productReqDto) {
        PrestaRootReq rootReq = ProductMapper.createProductXMLRequest(productReqDto);
        rootReq.getProduct().setId(productId);

        return xmlWebClient.put()
                .uri(PRODUCT_URL)
                .body(BodyInserters.fromValue(rootReq))
                .retrieve()
                .bodyToMono(PrestaRootRes.class)
                .flatMap(prestaRootRes -> Mono.just(prestaRootRes.getProduct()))
                .doOnError(throwable -> {
                    throw new NotFoundException("Product with product id " + productId + " not found.", 43);
                });
    }

    @Override
    public Mono<?> deleteProduct(Integer productId) {
        return xmlWebClient.delete()
                .uri(PRODUCT_URL + "/" + productId)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(throwable -> {
                    throw new NotFoundException("Product not width id "+ productId +" exist.", 44);
                });
    }

    @Override
    public Mono<ProductListResponse> loadProducts(
            Integer page, Integer limit,
            Integer category_id,
            List<String> reference,
            List<Integer> ids
    ) {
        AtomicReference<String> filter = new AtomicReference<>("");
        return webClient.get()
                .uri(uriBuilder -> buildUrl(uriBuilder, page, limit, category_id, reference, ids, filter))
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        var res = response.bodyToMono(ProductListResponse.class);

                        return res.map(data -> {
                            data.setSize(data.getProducts().size());
                            data.setPage(page);
                            data.setLimit(limit);
                            data.setFilter(filter.get());
                            return data;
                        }).doOnError(throwable -> {
                            log.error(throwable.getLocalizedMessage());
                            throw new BussinessException("Business Error mapping products", 3);
                        });
                    }

                    throw new BussinessException("Business Error mapping products", 1);
                })
                .doOnError(throwable -> {
                    log.error(throwable.getLocalizedMessage());
                    throw new NotFoundException("Products not fond");
                });
    }

    private String formatListOfParams(List<String> params) {
        return "[" + String.join("|", params) +"]";
    }

    private URI buildUrl(UriBuilder uriBuilder,
                         Integer page, Integer limit,
                         Integer category_id,
                         List<String> reference, List<Integer> ids,
                         AtomicReference<String> filter
    ) {

        if (category_id != null) {
            filter.set("[id_category_default]=" + category_id);
            uriBuilder.queryParam("filter[id_category_default]", category_id);
        }

        if ((reference != null) && (!reference.isEmpty())) {
            filter.set("[reference]=" + formatListOfParams(reference));
            uriBuilder.queryParam("filter[reference]" , formatListOfParams(reference));
        }

        if ((ids != null) && (!ids.isEmpty())) {
            filter.set("[id]=" + formatListOfParams(ids.stream().map(Object::toString).toList()));
            uriBuilder.queryParam("filter[id]", formatListOfParams(ids.stream().map(Object::toString).toList()));
        }

        return uriBuilder
                .path(PRODUCT_URL)
                .queryParam("output_format", "JSON")
                .queryParam("display", "full")
                .queryParam("limit", page + "," + limit)
                .build();
    }
}