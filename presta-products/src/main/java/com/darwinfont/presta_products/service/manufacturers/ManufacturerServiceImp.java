package com.darwinfont.presta_products.service.manufacturers;

import com.darwinfont.presta_products.domain.mapper.ManufacturerMapper;
import com.darwinfont.presta_products.domain.prestaShop.PrestaRootReq;
import com.darwinfont.presta_products.domain.prestaShop.PrestaRootRes;
import com.darwinfont.presta_products.domain.prestaShop.manufacturers.PrestaManufacturerRes;
import com.darwinfont.presta_products.domain.prestaShop.manufacturers.PrestaManufacturerRootRes;
import com.darwinfont.presta_products.domain.request.ManufacturerDTOReq;
import com.darwinfont.presta_products.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class ManufacturerServiceImp implements ManufacturerService {
    private final WebClient xmlWebClient;
    private final WebClient jsonWebClient;
    private final String MANUFACTURERS_URL = "/manufacturers";

    public ManufacturerServiceImp(
            @Qualifier("xmlRequest") WebClient xmlWebClient,
            @Qualifier("jsonRequest") WebClient jsonWebClient
    ) {
        this.xmlWebClient = xmlWebClient;
        this.jsonWebClient = jsonWebClient;
    }

    @Override
    public Mono<PrestaManufacturerRes> createManufacturers(ManufacturerDTOReq manufacturerDTOReq) {
        PrestaRootReq rootReq = ManufacturerMapper.dtoToXml(manufacturerDTOReq);
        return xmlWebClient.post()
                .uri(MANUFACTURERS_URL)
                .body(BodyInserters.fromValue(rootReq))
                .retrieve()
                .bodyToMono(PrestaManufacturerRootRes.class)
                .flatMap(prestaManufacturerRootRes -> Mono.just(prestaManufacturerRootRes.getManufacturer()));
    }

    @Override
    public Mono<List<PrestaManufacturerRes>> filterManufacturers(Integer id, String name, Boolean active) {
        return jsonWebClient.get()
                .uri(uriBuilder -> {
                    if (id != null) {
                        return uriBuilder.path(MANUFACTURERS_URL)
                                .queryParam("display", "full")
                                .queryParam("filter[id]", id)
                                .build();
                    }
                    if (name != null && !name.isEmpty()) {
                        return uriBuilder.path(MANUFACTURERS_URL)
                                .queryParam("display", "full")
                                .queryParam("filter[name]", name)
                                .build();
                    }
                    if (active != null) {
                        return uriBuilder.path(MANUFACTURERS_URL)
                                .queryParam("display", "full")
                                .queryParam("filter[active]", active ? 1 : 0)
                                .build();
                    }
                    return uriBuilder.path(MANUFACTURERS_URL)
                            .queryParam("display", "full")
                            .build();
                })
                .retrieve()
                .bodyToMono(PrestaRootRes.class)
                .flatMap(prestaRootRes -> Mono.just(prestaRootRes.getManufacturers()))
                .doOnError(throwable -> {
                    throw new NotFoundException("Manufactures not found");
                });
    }

    @Override
    public Mono<PrestaManufacturerRes> updateManufacturers(Integer id, ManufacturerDTOReq manufacturerDTOReq) {
        PrestaRootReq rootReq = ManufacturerMapper.dtoToXml(manufacturerDTOReq);
        rootReq.getManufacturer().setId(id);
        return xmlWebClient.put()
                .uri(MANUFACTURERS_URL)
                .body(BodyInserters.fromValue(rootReq))
                .retrieve()
                .bodyToMono(PrestaRootRes.class)
                .flatMap(prestaRootRes -> Mono.just(prestaRootRes.getManufacturer()))
                .doOnError(throwable -> {
                    throw new NotFoundException("Manufacturer not found");
                });
    }

    @Override
    public Mono<?> removeManufacturers(Integer id) {
        return xmlWebClient.delete()
                .uri(MANUFACTURERS_URL + "/" + id)
                .retrieve()
                .bodyToMono(Object.class)
                .doOnError(throwable -> {
                    throw new NotFoundException("Manufacturer not found");
                });
    }
}
