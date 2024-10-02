package com.darwinfont.presta_products.domain.prestaShop;

import com.darwinfont.presta_products.domain.prestaShop.manufacturers.PrestaManufacturerReq;
import com.darwinfont.presta_products.domain.prestaShop.product.PrestaProductReq;
import com.darwinfont.presta_products.domain.prestaShop.stock.PrestaStockReq;
import com.darwinfont.presta_products.domain.prestaShop.supplier.PrestaSupplierReq;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrestaRootReq {
    @XmlElement(name = "supplier")
    private PrestaSupplierReq supplier;
    @XmlElement(name = "manufacturer")
    private PrestaManufacturerReq manufacturer;
    @XmlElement(name = "product")
    private PrestaProductReq product;
    @XmlElement(name = "stock_available")
    private PrestaStockReq stockAvailable;
}
