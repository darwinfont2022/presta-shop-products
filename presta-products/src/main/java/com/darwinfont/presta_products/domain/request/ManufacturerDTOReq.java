package com.darwinfont.presta_products.domain.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class ManufacturerDTOReq {
    private Integer id;
    private Boolean active;
    private String linkRewrite;
    @NotNull
    @Length(max = 64)
    private String name;
    private String description;
    private String shortDescription;
}
