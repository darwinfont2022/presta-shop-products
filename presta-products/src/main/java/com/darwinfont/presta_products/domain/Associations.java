package com.darwinfont.presta_products.domain;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Associations {
    @XmlElement(name = "categories")
    private Categories categories;

    @XmlElement(name = "images")
    private Images images;
}