package com.darwinfont.presta_category.controller;

import com.darwinfont.presta_category.domain.request.CategoryCreateRequest;
import com.darwinfont.presta_category.domain.response.category.PrestaCategoryResponse;
import com.darwinfont.presta_category.service.createService.CategoryCreateService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/categories")
public class CategoryCreateController {
    private final CategoryCreateService categoryService;

    public CategoryCreateController(CategoryCreateService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    public Mono<PrestaCategoryResponse> createCategory(@RequestBody @Validated CategoryCreateRequest categoryCreateRequest) {
        return categoryService.createCategory(categoryCreateRequest);
    }
}
