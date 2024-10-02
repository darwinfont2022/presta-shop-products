package com.darwinfont.presta_products.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDTOReq {
    private String linkRewrite;
    private String name;
    private Boolean active;
    private String description;
}
