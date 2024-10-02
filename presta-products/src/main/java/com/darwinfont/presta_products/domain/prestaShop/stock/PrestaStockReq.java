package com.darwinfont.presta_products.domain.prestaShop.stock;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.*;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestaStockReq {
    private Integer id;
    private Integer quantity;
}
