package com.darwinfont.presta_products.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiExceptionMessage<T> {
    private Integer error;
    private T message;

}