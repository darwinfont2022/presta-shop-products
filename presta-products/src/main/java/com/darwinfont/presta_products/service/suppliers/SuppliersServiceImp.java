package com.darwinfont.presta_products.service.suppliers;

import com.darwinfont.presta_products.domain.mapper.SupplierMapper;
import com.darwinfont.presta_products.domain.prestaShop.PrestaRootReq;
import com.darwinfont.presta_products.domain.prestaShop.PrestaRootRes;
import com.darwinfont.presta_products.domain.prestaShop.supplier.PrestaSupplierRes;
import com.darwinfont.presta_products.domain.request.SupplierDTOReq;
import com.darwinfont.presta_products.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class SuppliersServiceImp implements SuppliersService {
    private final WebClient xmlWebClient;
    private final WebClient jsonWebClient;
    private final String SUPPLIER_URL = "/suppliers";

    public SuppliersServiceImp(
            @Qualifier("xmlRequest") WebClient xmlWebClient,
            @Qualifier("jsonRequest") WebClient jsonWebClient
    ) {
        this.xmlWebClient = xmlWebClient;
        this.jsonWebClient = jsonWebClient;
    }

    @Override
    public Mono<PrestaSupplierRes> createSupplier(SupplierDTOReq supplierDTO) {
        return xmlWebClient.post()
                .uri(SUPPLIER_URL)
                .body(BodyInserters.fromValue(SupplierMapper.supplierMapperToXML(supplierDTO)))
                .retrieve()
                .bodyToMono(PrestaRootRes.class)
                .flatMap(prestaRootRes -> Mono.just(prestaRootRes.getSupplier()));
    }

    @Override
    public Mono<List<PrestaSupplierRes>> filter(Integer id, Boolean active, String name, String description) {
        return jsonWebClient.get()
                .uri(uriBuilder -> {
                    if (id != null) {
                        return uriBuilder
                                .path(SUPPLIER_URL)
                                .queryParam("display", "full")
                                .queryParam("filter[id]", id)
                                .build();
                    }
                    if (active != null) {
                        return uriBuilder
                                .path(SUPPLIER_URL)
                                .queryParam("display", "full")
                                .queryParam("filter[active]", active ? 1 : 0)
                                .build();
                    }
                    if (name != null && !name.isEmpty()) {
                        return uriBuilder
                                .path(SUPPLIER_URL)
                                .queryParam("display", "full")
                                .queryParam("filter[name]", name)
                                .build();
                    }
                    return uriBuilder
                            .path(SUPPLIER_URL)
                            .queryParam("display", "full")
                            .build();
                })
                .retrieve()
                .bodyToMono(PrestaRootRes.class)
                .flatMap(prestaRootRes -> Mono.just(prestaRootRes.getSuppliers()))
                .doOnError(throwable -> {
                    throw new NotFoundException("Suppliers not found");
                });
    }

    @Override
    public Mono<PrestaSupplierRes> updateSupplier(Integer id, SupplierDTOReq supplierDTOReq) {
        PrestaRootReq req = SupplierMapper.supplierMapperToXML(supplierDTOReq);
        req.getSupplier().setId(id);
        return xmlWebClient.put()
                .uri(SUPPLIER_URL)
                .body(BodyInserters.fromValue(req))
                .retrieve()
                .bodyToMono(PrestaRootRes.class)
                .flatMap(prestaRootRes -> Mono.just(prestaRootRes.getSupplier()))
                .doOnError(throwable -> {
                    throw new NotFoundException("Supplier not found");
                });
    }

    @Override
    public Mono<?> removeSupplier(Integer id) {
        return xmlWebClient.delete()
                .uri(SUPPLIER_URL + "/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .doOnError(throwable -> {
                    throw new NotFoundException("Supplier not found");
                });
    }
}
