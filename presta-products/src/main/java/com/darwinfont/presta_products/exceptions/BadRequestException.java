package com.darwinfont.presta_products.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends RuntimeException{
    private int code;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, int code) {
        super(message);
        this.code = code;
    }
}