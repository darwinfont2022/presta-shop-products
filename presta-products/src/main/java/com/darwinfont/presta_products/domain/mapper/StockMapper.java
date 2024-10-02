package com.darwinfont.presta_products.domain.mapper;

import com.darwinfont.presta_products.domain.prestaShop.PrestaRootReq;
import com.darwinfont.presta_products.domain.prestaShop.stock.PrestaStockReq;

public class StockMapper {
    public static PrestaRootReq xmlReq(Integer stockId, Integer quantity) {
        return PrestaRootReq.builder()
                .stockAvailable(
                        PrestaStockReq.builder()
                        .id(stockId)
                        .quantity(quantity)
                        .build()
                ).build();
    }
}
