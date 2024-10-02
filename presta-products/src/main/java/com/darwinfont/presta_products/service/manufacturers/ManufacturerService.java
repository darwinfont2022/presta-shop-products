package com.darwinfont.presta_products.service.manufacturers;

import com.darwinfont.presta_products.domain.prestaShop.manufacturers.PrestaManufacturerRes;
import com.darwinfont.presta_products.domain.request.ManufacturerDTOReq;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ManufacturerService {
    Mono<PrestaManufacturerRes> createManufacturers(ManufacturerDTOReq manufacturerDTOReq);
    Mono<List<PrestaManufacturerRes>> filterManufacturers(Integer id, String name, Boolean active);
    Mono<PrestaManufacturerRes> updateManufacturers(Integer id, ManufacturerDTOReq manufacturerDTOReq);
    Mono<?> removeManufacturers(Integer id);
}
