package com.darwinfont.presta_products.controller.suppliers;

import com.darwinfont.presta_products.domain.request.SupplierDTOReq;
import com.darwinfont.presta_products.service.suppliers.SuppliersService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/suppliers")
public class SuppliersController {
    private final SuppliersService suppliersService;

    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @PostMapping
    public Mono<?> saveSupplier(@RequestBody @Validated SupplierDTOReq supplierDTO) {
        return suppliersService.createSupplier(supplierDTO);
    }

    @GetMapping()
    public Mono<?> filterSupplier(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Boolean active
    ) {
        return suppliersService.filter(id, active, name, description);
    }

    @PutMapping("/{id}")
    public Mono<?> updateSupplier(@PathVariable Integer id, @RequestBody SupplierDTOReq supplierDTOReq) {
        return suppliersService.updateSupplier(id, supplierDTOReq);
    }

    @DeleteMapping("/{id}")
    public Mono<?> removeSupplier(@PathVariable Integer id){
        return suppliersService.removeSupplier(id);
    }
}
