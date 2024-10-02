package com.darwinfont.presta_category.domain.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "prestashop")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrestaCategoryRoot {
    @XmlElement(name = "category")
    private PrestaCategoryRequest category;
}

