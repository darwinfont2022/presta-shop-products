package com.darwinfont.presta_products.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private Integer id_manufacturer;
    private Integer id_supplier;
    private Integer id_category_default;
//    private Integer cache_default_attribute;
    private Integer id_default_image;
    private Integer id_default_combination;
    private Integer id_tax_rules_group;
    private Integer position_in_category;
    private String manufacturer_name;
    private String type;
    private Integer id_shop_default;
    private String reference;
    private String supplier_reference;
    private String location;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal depth;
    private BigDecimal weight;
    private Integer state;
    private Integer additional_delivery_times;
    private String product_type;
    private BigDecimal ecotax;
    private Integer minimal_quantity;
    private Integer quantity_discount;
    private BigDecimal price;
    private BigDecimal wholesale_price;
    private BigDecimal unit_price;
    private BigDecimal unit_price_ratio;
    private BigDecimal additional_shipping_cost;
    private String customizable;
    private String text_fields;
    private String uploadable_files;
    private Integer active;
    private String redirect_type;
    private String available_for_order;
    private Date available_date;
    private String show_condition;
    private String condition;
    private String show_price;
    private String indexed;
    private String visibility;
    private String advanced_stock_management;
    private Integer pack_stock_type;
    private String meta_description;
    private String meta_keywords;
    private String meta_title;
    private String link_rewrite;
    private String name;
    private String description;
    private String description_short;
    private String date_add;
    private String date_upd;
    private AssociationsResponse associations;
}