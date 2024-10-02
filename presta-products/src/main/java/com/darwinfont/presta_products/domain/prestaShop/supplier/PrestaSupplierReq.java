package com.darwinfont.presta_products.domain.prestaShop.supplier;

import com.darwinfont.presta_products.domain.prestaShop.LanguageWrapper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
public class PrestaSupplierReq {
    private Integer id;
    @XmlElement(name = "link_rewrite")
    private String linkRewrite;
    private String name;
    private Integer active;
    private LanguageWrapper description;
}
