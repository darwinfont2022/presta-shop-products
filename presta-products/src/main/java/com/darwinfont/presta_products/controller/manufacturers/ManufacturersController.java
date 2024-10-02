package com.darwinfont.presta_products.controller.manufacturers;

import com.darwinfont.presta_products.domain.prestaShop.manufacturers.PrestaManufacturerRes;
import com.darwinfont.presta_products.domain.request.ManufacturerDTOReq;
import com.darwinfont.presta_products.service.manufacturers.ManufacturerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturersController {
    private final ManufacturerService manufacturerService;

    public ManufacturersController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    public Mono<?> saveManufacturer(@RequestBody ManufacturerDTOReq manufacturerDTOReq) {
        return manufacturerService.createManufacturers(manufacturerDTOReq);
    }

    @GetMapping
    public Mono<?> filterManufacture(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean active) {
        return manufacturerService.filterManufacturers(id, name, active);
    }

    @PutMapping("/{id}")
    public Mono<PrestaManufacturerRes> updateManufacturer(
            @PathVariable Integer id,
            @RequestBody @Validated ManufacturerDTOReq manufacturerDTO
    ) {
        return manufacturerService.updateManufacturers(id, manufacturerDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<?> deleteManufacturer(@PathVariable Integer id) {
        return manufacturerService.removeManufacturers(id);
    }
}
