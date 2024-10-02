package com.darwinfont.presta_products.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssociationsResponse {
    private List<IdReferenceDto> categories;
    private List<IdReferenceDto> images;
    private List<IdReferenceDto> combinations;
    @JsonProperty("product_option_values")
    private List<IdReferenceDto> productOptionValues;
    @JsonProperty("product_features")
    private List<IdReferenceDto> productFeatures;
    @JsonProperty("stock_availables")
    private List<PrestaProductStockAvailableRes> stockAvailables;
}