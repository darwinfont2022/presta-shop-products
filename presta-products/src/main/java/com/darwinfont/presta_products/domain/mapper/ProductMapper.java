package com.darwinfont.presta_products.domain.mapper;

import com.darwinfont.presta_products.domain.prestaShop.product.PrestaProductReq;
import com.darwinfont.presta_products.domain.prestaShop.PrestaRootReq;
import com.darwinfont.presta_products.domain.request.ProductRequest;

public class ProductMapper {
    public static PrestaRootReq createProductXMLRequest(ProductRequest jsonRequest){
        PrestaProductReq xmlRequest = PrestaProductReq.builder()
                .idManufacturer(jsonRequest.getIdManufacturer())
                .idSupplier(jsonRequest.getIdSupplier())
                .idCategoryDefault(
                        jsonRequest.getIdCategoryDefault() != null ? jsonRequest.getIdCategoryDefault() : 1
                )
                .idDefaultCombination(jsonRequest.getIdDefaultCombination())
                .idTaxRulesGroup(jsonRequest.getIdTaxRulesGroup())
                .type(jsonRequest.getType())
                .idShopDefault(jsonRequest.getIdShopDefault())
                .reference(jsonRequest.getReference())
                .supplierReference(jsonRequest.getSupplierReference())
                .ean13(jsonRequest.getEan13())
                .state(jsonRequest.getState())
                .productType(jsonRequest.getType())
                .price(jsonRequest.getPrice())
                .unitPrice(jsonRequest.getUnitPrice())
                .active(jsonRequest.getActive())
                .isNew(jsonRequest.getIsNew() ? 1 : 0)
                .name(LanguageMapper.genereteOneLanguageWrapper(1,jsonRequest.getName()))
                .description(LanguageMapper.genereteOneLanguageWrapper(1, jsonRequest.getDescription()))
                .weight(jsonRequest.getWeight())
                .width(jsonRequest.getWidth())
                .height(jsonRequest.getHeight())
                .depth(jsonRequest.getDepth())
                .quantityDiscount(jsonRequest.getQuantityDiscount() != null && jsonRequest.getQuantityDiscount() ? 1 : 0)
                .build();

//        xmlRequest.setId(jsonRequest.getId());
//        xmlRequest.setIdManufacturer(jsonRequest.getIdManufacturer());
//        xmlRequest.setIdSupplier(jsonRequest.getIdSupplier());
//        xmlRequest.setIdCategoryDefault(jsonRequest.getIdCategoryDefault());
//        xmlRequest.setIsNew(jsonRequest.getIsNew() ? 1 : 0);
//
//        xmlRequest.setIdDefaultImage(jsonRequest.getIdDefaultImage());
//        xmlRequest.setIdDefaultCombination(jsonRequest.getIdDefaultCombination());
//        xmlRequest.setIdTaxRulesGroup(jsonRequest.getIdTaxRulesGroup());
//        xmlRequest.setType(jsonRequest.getType());
//        xmlRequest.setIdShopDefault(jsonRequest.getIdShopDefault());
//        xmlRequest.setReference(jsonRequest.getReference());
//        xmlRequest.setSupplierReference(jsonRequest.getSupplierReference());
//        xmlRequest.setLocation(jsonRequest.getLocation());
//        xmlRequest.setWidth(jsonRequest.getWidth());
//        xmlRequest.setHeight(jsonRequest.getHeight());
//        xmlRequest.setDepth(jsonRequest.getDepth());
//        xmlRequest.setWeight(jsonRequest.getWeight());
//        xmlRequest.setQuantityDiscount(jsonRequest.getQuantityDiscount());
//        xmlRequest.setEan13(jsonRequest.getEan13());
//        xmlRequest.setIsbn(jsonRequest.getIsbn());
//        xmlRequest.setUpc(jsonRequest.getUpc());
//        xmlRequest.setMpn(jsonRequest.getMpn());

        return PrestaRootReq.builder().product(xmlRequest).build();
    }
}
