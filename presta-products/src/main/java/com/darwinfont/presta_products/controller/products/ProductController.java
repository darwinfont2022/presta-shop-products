package com.darwinfont.presta_products.controller.products;

import com.darwinfont.presta_products.domain.request.ProductRequest;
import com.darwinfont.presta_products.domain.response.PrestaProductRes;
import com.darwinfont.presta_products.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(produces = "application/json")
    public Mono<?> saveProduct(@RequestBody @Validated ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping("/{product_id}")
    public Mono<PrestaProductRes> getProductById(
           @PathVariable Integer product_id
    ) {
        return productService.getProductById(product_id);
    }

    @GetMapping()
    public Mono<?> filterProducts(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit,
            @RequestParam(required = false) Integer id_category_default,
            @RequestParam(required = false) List<String> reference,
            @RequestParam(required = false) List<Integer> ids,
            @RequestParam(required = false) String title
                                  ) {
        return productService.loadProducts(
                page, limit,
                id_category_default,
                reference,
                ids);
    }

    @PutMapping("/{id}")
    public Mono<?> updateProduct(@PathVariable Integer id, @RequestBody ProductRequest productDTO ) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<?> deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }
}