package com.darwinfont.presta_category.domain.response.category;

import com.darwinfont.presta_category.domain.response.AssociationsResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryResponse {
    private Integer id;
    @JsonProperty("idParent")
    private Integer id_parent;
    @JsonProperty("levelDepth")
    private Integer level_depth;
    @JsonProperty("productsRecursive")
    private Integer nb_products_recursive;
    private Integer active;
    @JsonProperty("idShopDefault")
    private Integer id_shop_default;
    @JsonProperty("isRootCategory")
    private Integer is_root_category;
    private Integer position;
    @JsonProperty("dateAdd")
    private String date_add;
    @JsonProperty("dateUpd")
    private String date_upd;
    private String name;
    @JsonProperty("linkRewrite")
    private String link_rewrite;
    private String description;
    @JsonProperty("additionalDescription")
    private String additional_description;
    @JsonProperty("metaTitle")
    private String meta_title;
    @JsonProperty("metaDescription")
    private String meta_description;
    @JsonProperty("metaKeywords")
    private String meta_keywords;
    private AssociationsResponse associations;
}
