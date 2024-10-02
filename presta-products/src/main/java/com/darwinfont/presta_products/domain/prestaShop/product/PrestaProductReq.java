package com.darwinfont.presta_products.domain.prestaShop.product;

import com.darwinfont.presta_products.domain.prestaShop.LanguageWrapper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestaProductReq {
    @XmlElement(name = "id")
    private Integer id;
//
    @XmlElement(name = "id_manufacturer")
    private Integer idManufacturer;
//
    @XmlElement(name = "id_supplier")
    private Integer idSupplier;
//
    @XmlElement(name = "id_category_default")
    private Integer idCategoryDefault;
//
    @XmlElement(name = "new")
    private Integer isNew;
//
//    @XmlElement(name = "cache_default_attribute")
//    private String cache_default_attribute;
//
//    @XmlElement(name = "id_default_image")
//    private Integer idDefaultImage;
//
    @XmlElement(name = "id_default_combination")
    private Integer idDefaultCombination;

    @XmlElement(name = "id_tax_rules_group")
    private Integer idTaxRulesGroup;

    @XmlElement(name = "type")
    private String type;
//
    @XmlElement(name = "id_shop_default")
    private Integer idShopDefault;
//
    @XmlElement(name = "reference")
    private String reference;
//    @XmlElement(name = "location")
//    private String location;

    @XmlElement(name = "supplier_reference")
    private String supplierReference;

    @XmlElement(name = "ean13")
    private String ean13;

    @XmlElement(name = "state")
    private String state;

    @XmlElement(name = "product_type")
    private String productType;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "unit_price")
    private BigDecimal unitPrice;
    @XmlElement(name = "active")
    private Integer active;

    @XmlElement(name = "name")
    private LanguageWrapper name;
    @XmlElement(name = "description")
    private LanguageWrapper description;

    @XmlElement(name = "meta_description")
    private LanguageWrapper metaDescription;
    @XmlElement(name = "meta_title")
    private LanguageWrapper metaTitle;

    @XmlElement(name = "width")
    private BigDecimal width;

    @XmlElement(name = "height")
    private BigDecimal height;

    @XmlElement(name = "depth")
    private BigDecimal depth;

    @XmlElement(name = "weight")
    private BigDecimal weight;

    @XmlElement(name = "quantity_discount")
    private Integer quantityDiscount;

//
//    @XmlElement(name = "isbn")
//    private String isbn;
//
//    @XmlElement(name = "upc")
//    private String upc;
//
//    @XmlElement(name = "mpn")
//    private String mpn;

//    @XmlElement(name = "cache_is_pack")
//    private Integer cacheIsPack;

//    @XmlElement(name = "cache_has_attachments")
//    private Integer cacheHasAttachments;

//    @XmlElement(name = "is_virtual")
//    private Integer isVirtual;



//    @XmlElement(name = "additional_delivery_times")
//    private Integer additionalDeliveryTimes;

//    @XmlElement(name = "delivery_in_stock")
//    private Delivery deliveryInStock;
//
//    @XmlElement(name = "delivery_out_stock")
//    private Delivery deliveryOutStock;
//

//
//    @XmlElement(name = "on_sale")
//    private Integer onSale;
//
//    @XmlElement(name = "online_only")
//    private Integer onlineOnly;
//
//    @XmlElement(name = "ecotax")
//    private String ecotax;
//
//    @XmlElement(name = "minimal_quantity")
//    private String minimalQuantity;
//
//    @XmlElement(name = "low_stock_threshold")
//    private String lowStockThreshold;
//
//    @XmlElement(name = "low_stock_alert")
//    private String lowStockAlert;

//    @XmlElement(name = "wholesale_price")
//    private String wholesalePrice;
//
//    @XmlElement(name = "unity")
//    private String unity;
//
//
//    @XmlElement(name = "unit_price_ratio")
//    private String unitPriceRatio;
//
//    @XmlElement(name = "additional_shipping_cost")
//    private BigDecimal additionalShippingCost;
//
//    @XmlElement(name = "customizable")
//    private String customizable;
//
//    @XmlElement(name = "text_fields")
//    private String textFields;
//
//    @XmlElement(name = "uploadable_files")
//    private String uploadableFiles;
//
//
//    @XmlElement(name = "redirect_type")
//    private String redirectType;
//
//    @XmlElement(name = "id_type_redirected")
//    private Integer idTypeRedirected;
//
//    @XmlElement(name = "available_for_order")
//    private Integer availableForOrder;
//
//    @XmlElement(name = "available_date")
//    private String available_date;
//
//    @XmlElement(name = "show_condition")
//    private Integer showCondition;
//
//    @XmlElement(name = "condition")
//    private String condition;
//
//    @XmlElement(name = "show_price")
//    private Integer showPrice;
//
//    @XmlElement(name = "indexed")
//    private String indexed;
//
//    @XmlElement(name = "visibility")
//    private String visibility;
//
//    @XmlElement(name = "advanced_stock_management")
//    private String advancedStockManagement;
//
//    @XmlElement(name = "pack_stock_type")
//    private String packStockType;
//
//
//    @XmlElement(name = "meta_keywords")
//    private LanguageWrapper metaKeywords;
//
//
//    @XmlElement(name = "link_rewrite")
//    private String linkRewrite;
//
//

//
//    @XmlElement(name = "description_short")
//    private String descriptionShort;
//
//    @XmlElement(name = "available_now")
//    private String availableNow;
//
//    @XmlElement(name = "available_later")
//    private String availableLater;
//
//    @XmlElement(name = "associations")
//    private Associations associations;
}