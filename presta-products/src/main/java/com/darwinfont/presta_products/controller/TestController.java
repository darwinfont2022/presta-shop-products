package com.darwinfont.presta_products.controller;

import com.darwinfont.presta_products.domain.mapper.ProductMapper;
import com.darwinfont.presta_products.domain.request.ProductRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class TestController {
    @PostMapping(path = "/test", produces = "application/xml")
    public Mono<?>getSchema(@RequestBody ProductRequest req) {

        return Mono.just(ProductMapper.createProductXMLRequest(req));
    }
}
