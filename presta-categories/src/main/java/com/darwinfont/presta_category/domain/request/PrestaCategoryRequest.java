package com.darwinfont.presta_category.domain.request;

import com.darwinfont.presta_category.domain.Associations;
import com.darwinfont.presta_category.domain.LanguageWrapper;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class PrestaCategoryRequest {
    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "id_parent")
    private Integer idParent;

    @XmlElement(name = "level_depth")
    private Integer levelDepth;

    @XmlElement(name = "active")
    private Integer active;

    @XmlElement(name = "id_shop_default")
    private Integer idShopDefault;

    @XmlElement(name = "is_root_category")
    private Integer isRootCategory;

    @XmlElement(name = "name")
    private LanguageWrapper name;

    @XmlElement(name = "link_rewrite")
    private LanguageWrapper linkRewrite;

    @XmlElement(name = "description")
    private LanguageWrapper description;

    @XmlElement(name = "meta_title")
    private LanguageWrapper metaTitle;

    @XmlElement(name = "meta_description")
    private LanguageWrapper metaDescription;

    @XmlElement
    private Associations associations;
}