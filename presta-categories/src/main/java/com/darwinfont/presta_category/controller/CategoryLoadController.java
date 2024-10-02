package com.darwinfont.presta_category.controller;

import com.darwinfont.presta_category.domain.response.category.CategoryListResponse;
import com.darwinfont.presta_category.service.loadService.CategoryLoadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryLoadController {
    private final CategoryLoadService categoryLoadService;

    public CategoryLoadController(CategoryLoadService categoryLoadService) {
        this.categoryLoadService = categoryLoadService;
    }

    @GetMapping("/available-filters")
    public Mono<List<String>> loadAvailableFilters() {
        return categoryLoadService.availableFilters();
    }

    @GetMapping("/filter")
    public Mono<CategoryListResponse> filterCategories(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) List<Integer> id,
            @RequestParam(required = false) String filter,
            @RequestParam(required = false) String filter_value
    ) {
        return categoryLoadService.categoryFilter(name, id, filter, filter_value);
    }
}
