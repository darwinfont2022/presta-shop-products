package com.darwinfont.presta_products.domain.prestaShop.manufacturers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrestaManufacturerRes {
    private Integer id;
    private Integer active;

    @JsonProperty(value = "link_rewrite")
    private String linkRewrite;

    private String name;
    private String description;

    @JsonProperty(value = "short_description")
    private String shortDescription;
    @JsonProperty(value = "date_add")
    private String dateAdd;
    @JsonProperty(value = "date_upd")
    private String dateUpd;
}
