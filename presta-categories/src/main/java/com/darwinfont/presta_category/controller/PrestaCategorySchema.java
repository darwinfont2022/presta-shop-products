package com.darwinfont.presta_category.controller;

import com.darwinfont.presta_category.domain.mapper.CategoryMapper;
import com.darwinfont.presta_category.domain.request.PrestaCategoryRequest;
import com.darwinfont.presta_category.domain.request.PrestaCategoryRoot;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories/schema")
public class PrestaCategorySchema {

    @GetMapping(value = "/xml", produces = "application/xml")
    public ResponseEntity<?> xml() {
        return new ResponseEntity<>(createCategory(), HttpStatus.OK);
    }

    @GetMapping("/json")
    public ResponseEntity<?> jsonSchema() {
        return new ResponseEntity<>(createCategory(), HttpStatus.OK);
    }

    private PrestaCategoryRoot createCategory() {
        PrestaCategoryRequest request = new PrestaCategoryRequest();
        request.setActive(1);
        request.setIdParent(1);
        request.setDescription(CategoryMapper.genereteOneLanguageWrapper(1, "Category Description Test"));
        request.setName(CategoryMapper.genereteOneLanguageWrapper(1, "Category Name Test"));
        request.setLinkRewrite(CategoryMapper.genereteOneLanguageWrapper(1, "Link rewrite category_test"));

        return new PrestaCategoryRoot(request);
    }
}