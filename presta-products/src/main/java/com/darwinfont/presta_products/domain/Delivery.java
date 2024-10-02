package com.darwinfont.presta_products.domain;

import com.darwinfont.presta_products.domain.prestaShop.Language;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Delivery {
    @XmlElement(name = "language")
    private List<Language> languages;
}