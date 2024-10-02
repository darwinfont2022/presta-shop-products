package com.darwinfont.presta_products.domain.response;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestaResponse<T> {
    @JsonAnySetter
    private T item;
}