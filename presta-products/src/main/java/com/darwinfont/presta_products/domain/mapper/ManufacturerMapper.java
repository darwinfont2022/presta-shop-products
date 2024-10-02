package com.darwinfont.presta_products.domain.mapper;

import com.darwinfont.presta_products.domain.prestaShop.PrestaRootReq;
import com.darwinfont.presta_products.domain.prestaShop.manufacturers.PrestaManufacturerReq;
import com.darwinfont.presta_products.domain.request.ManufacturerDTOReq;

public class ManufacturerMapper {
    public static PrestaRootReq dtoToXml(ManufacturerDTOReq dtoReq) {
        PrestaManufacturerReq manufacturer = PrestaManufacturerReq
                .builder()
                .id(dtoReq.getId())
                .active(dtoReq.getActive() != null && dtoReq.getActive() ? 1 : 0)
                .linkRewrite(dtoReq.getLinkRewrite())
                .name(dtoReq.getName())
                .description(LanguageMapper.genereteOneLanguageWrapper(1, dtoReq.getDescription()))
                .shortDescription(LanguageMapper.genereteOneLanguageWrapper(1, dtoReq.getShortDescription()))
                .build();

        return PrestaRootReq.builder()
                .manufacturer(manufacturer)
                .build();
    }
}
