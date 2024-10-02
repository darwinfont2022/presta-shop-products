package com.darwinfont.presta_products.domain.request;

import com.darwinfont.presta_products.domain.response.AssociationsResponse;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {
    private Integer id;
    private Integer idManufacturer;
    private Integer idSupplier;
    private Integer idCategoryDefault;
    private Boolean isNew;
    private Integer idDefaultImage;
    private Integer idDefaultCombination;
    private Integer idTaxRulesGroup;
    private String type;
    private Integer idShopDefault;
    private String reference;
    private String supplierReference;
    private String ean13;
    private String state;
    private String location;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal depth;
    private BigDecimal weight;
    private Boolean quantityDiscount;
    private String isbn;
    private String upc;
    private String mpn;

    @NotNull(message = "price is required by prestashop api")
    private BigDecimal price;
    private BigDecimal unitPrice;
    private Integer idParent;
    private Integer levelDepth;
    private Integer productsRecursive;
    private Integer active;
    private Integer isRootCategory;
    private Integer position;
    private String name;
    private String linkRewrite;
    private String description;
    private String additionalDescription;
    private String metaTitle;
    private String metaDescription;
    private String metaKeywords;
    private AssociationsResponse associations;
}