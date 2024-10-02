package com.darwinfont.presta_products.service.suppliers;

import com.darwinfont.presta_products.domain.prestaShop.supplier.PrestaSupplierRes;
import com.darwinfont.presta_products.domain.request.SupplierDTOReq;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SuppliersService {
    Mono<PrestaSupplierRes> createSupplier(SupplierDTOReq supplierDTO);
    Mono<List<PrestaSupplierRes>> filter(Integer id, Boolean active, String name, String description);
    Mono<PrestaSupplierRes> updateSupplier(Integer id, SupplierDTOReq supplierDTOReq);
    Mono<?> removeSupplier(Integer id);
}
