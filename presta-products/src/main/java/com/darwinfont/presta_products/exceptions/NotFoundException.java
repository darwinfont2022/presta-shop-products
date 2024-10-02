package com.darwinfont.presta_products.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{
    private int code;

    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException(String message, int code) {
        super(message);
        this.code = code;
    }
}