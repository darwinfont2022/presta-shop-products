package com.darwinfont.presta_category.domain;

import com.darwinfont.presta_category.domain.response.ProductWrapper;
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
    private CategoryWrapper categories;
    @XmlElement(name = "products")
    private ProductWrapper products;
}
