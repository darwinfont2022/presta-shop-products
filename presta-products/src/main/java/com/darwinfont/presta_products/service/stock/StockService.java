package com.darwinfont.presta_products.service.stock;

import com.darwinfont.presta_products.domain.request.StockDTOReq;
import reactor.core.publisher.Mono;

public interface StockService {
    Mono<?> updateStock(Integer stockId, StockDTOReq stockDTOReq);

    Mono<?> findStock(Integer productId);
}
