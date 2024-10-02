package com.darwinfont.presta_products.domain.prestaShop.manufacturers;

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
public class PrestaManufacturerReq {
    @XmlElement
    private Integer id;
    @XmlElement
    private Integer active;
    @XmlElement(name = "link_rewrite")
    private String linkRewrite;
    @XmlElement
    private String name;
    @XmlElement
    private LanguageWrapper description;
    @XmlElement(name = "short_description")
    private LanguageWrapper shortDescription;
    @XmlElement(name = "date_add")
    private String dateAdd;
    @XmlElement(name = "date_upd")
    private String dateUpd;
}
