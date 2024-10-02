package com.darwinfont.presta_category.controller;

import com.darwinfont.presta_category.domain.request.CategoryUpdateRequest;
import com.darwinfont.presta_category.service.updateService.CategoryUpdateService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/categories")
public class CategoryUpdateController {
    private final CategoryUpdateService categoryUpdateService;

    public CategoryUpdateController(CategoryUpdateService categoryUpdateService) {
        this.categoryUpdateService = categoryUpdateService;
    }

    @PutMapping("/{id}")
    public Mono<?> updateCategory(@RequestBody CategoryUpdateRequest categoryDto, @PathVariable Integer id){
        return categoryUpdateService.updateCategory(categoryDto, id);
    }
}