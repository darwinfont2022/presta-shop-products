package com.darwinfont.presta_products.domain.response.category;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CategoryListResponse {
    private int size;
    private String filter;
    private String filter_value;
    private List<CategoryResponse> categories;
}