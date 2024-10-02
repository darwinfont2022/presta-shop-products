package com.darwinfont.presta_products.service.stock;

import com.darwinfont.presta_products.domain.mapper.StockMapper;
import com.darwinfont.presta_products.domain.prestaShop.PrestaRootRes;
import com.darwinfont.presta_products.domain.request.StockDTOReq;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StockServiceImp implements StockService {
    private final WebClient jsonWebClient;
    private final WebClient xmlWebClient;
    private final String STOCK_AVAILABLE_URL = "/stock_availables";

    public StockServiceImp(
            @Qualifier("jsonRequest") WebClient jsonWebClient,
            @Qualifier("xmlRequest") WebClient xmlWebClient
    ) {
        this.jsonWebClient = jsonWebClient;
        this.xmlWebClient = xmlWebClient;
    }

    @Override
    public Mono<?> updateStock(Integer stockId, StockDTOReq stockDTOReq) {
        return xmlWebClient.patch()
                .uri(uriBuilder -> uriBuilder
                        .path(STOCK_AVAILABLE_URL)
                        .queryParam("display", "full")
                        .build()
                )
                .body(BodyInserters.fromValue(StockMapper.xmlReq(stockId, stockDTOReq.getQuantity())))
                .retrieve()
                .bodyToMono(PrestaRootRes.class)
                .flatMap(prestaRootRes -> Mono.just(prestaRootRes.getStockAvailables()));
    }

    @Override
    public Mono<?> findStock(Integer productId) {
        return jsonWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(STOCK_AVAILABLE_URL)
                        .queryParam("display", "full")
                        .queryParam("filter[id_product]", productId)
                        .build()
                ).retrieve()
                .bodyToMono(PrestaRootRes.class);
    }

}
