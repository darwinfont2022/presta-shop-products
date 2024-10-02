package com.darwinfont.presta_products.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductListResponse {
    private Integer page;
    private Integer limit;
    private Integer size;
    private String filter;
    private List<ProductResponse> products;
}