package com.darwinfont.presta_products.controller.stock;

import com.darwinfont.presta_products.domain.request.StockDTOReq;
import com.darwinfont.presta_products.service.stock.StockService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    Mono<?> findStock(@RequestParam Integer productId) {
        return stockService.findStock(productId);
    }

    @PatchMapping("/{stockId}")
    private Mono<?> updateStock(@PathVariable Integer stockId, @RequestBody StockDTOReq stockDTOReq) {
        return stockService.updateStock(stockId, stockDTOReq);
    }
}
