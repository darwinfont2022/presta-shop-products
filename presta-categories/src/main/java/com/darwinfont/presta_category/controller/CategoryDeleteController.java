package com.darwinfont.presta_category.controller;

import com.darwinfont.presta_category.service.deleteService.CategoryDeleteService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryDeleteController {
    private final CategoryDeleteService categoryDeleteService;

    public CategoryDeleteController(CategoryDeleteService categoryDeleteService) {
        this.categoryDeleteService = categoryDeleteService;
    }
}
