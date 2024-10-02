package com.darwinfont.presta_category.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BussinessException extends RuntimeException {
    private int code;

    public BussinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BussinessException(String message) {
        super(message);
        this.code = 0;
    }
}
