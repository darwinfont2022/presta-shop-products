package com.darwinfont.presta_products.domain.mapper;

import com.darwinfont.presta_products.domain.prestaShop.PrestaRootReq;
import com.darwinfont.presta_products.domain.prestaShop.supplier.PrestaSupplierReq;
import com.darwinfont.presta_products.domain.request.SupplierDTOReq;

public class SupplierMapper {
    public static PrestaRootReq supplierMapperToXML(SupplierDTOReq supplierDTOReq) {
        return PrestaRootReq.builder()
                .supplier(
                        PrestaSupplierReq
                        .builder()
                                .active(supplierDTOReq.getActive() != null && supplierDTOReq.getActive() ? 1 : 0)
                                .name(supplierDTOReq.getName())
                                .linkRewrite(supplierDTOReq.getLinkRewrite())
                                .description(LanguageMapper.genereteOneLanguageWrapper(1, supplierDTOReq.getDescription()))
                        .build()
                )
                .build();
    }
}
