package com.darwinfont.presta_category.controller;

import com.darwinfont.presta_category.domain.mapper.CategoryMapper;
import com.darwinfont.presta_category.domain.request.CategoryCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class TestController {
    @PostMapping(path = "/test", produces = "application/xml")
    public ResponseEntity<?> test(@RequestBody CategoryCreateRequest dto) {
        return new ResponseEntity<>(CategoryMapper.createPrestaCategory(dto, 1), HttpStatus.OK);
    }
}