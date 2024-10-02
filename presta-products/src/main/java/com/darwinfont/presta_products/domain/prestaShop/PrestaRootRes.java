package com.darwinfont.presta_products.domain.prestaShop;

import com.darwinfont.presta_products.domain.prestaShop.manufacturers.PrestaManufacturerRes;
import com.darwinfont.presta_products.domain.prestaShop.supplier.PrestaSupplierRes;
import com.darwinfont.presta_products.domain.response.ProductResponse;
import com.darwinfont.presta_products.domain.response.PrestaStockAvailableRes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrestaRootRes {
    private PrestaSupplierRes supplier;
    private List<PrestaSupplierRes> suppliers;
    private PrestaManufacturerRes manufacturer;
    private List<PrestaManufacturerRes> manufacturers;
    private ProductResponse product;
    private List<ProductResponse> products;
    @JsonProperty("stock_availables")
    private List<PrestaStockAvailableRes> stockAvailables;
}
