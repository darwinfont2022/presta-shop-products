package com.darwinfont.presta_products.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrestaStockAvailableRes {
    private Integer id;
    @JsonProperty("id_product")
    private Integer idProduct;
    @JsonProperty("id_product_attribute")
    private Integer idProductAttribute;
    @JsonProperty("id_shop")
    private Integer idShop;
    @JsonProperty("id_shop_group")
    private Integer idShopGroup;
    private Integer quantity;
    @JsonProperty("depends_on_stock")
    private Integer dependsOnStock;
    @JsonProperty("out_of_stock")
    private Integer outOfStock;
}