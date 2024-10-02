package com.darwinfont.presta_category.domain.request;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
public class CategoryUpdateRequest {
    private String name;
    private String description;
    @Min(0)
    private Integer idParent;
    private Boolean active;
    @Length(message = "isRootCategory is mandatory")
    private Boolean isRootCategory;
    @URL(message = "Must be an valid url")
    private String linkRewrite;
    @Length(max = 255, message = "meta_title must have a maximum of 255 characters.")
    private String metaTitle;
    @Length(max = 512, message = "metaDescription must have a maximum of 512 characters.")
    private String metaDescription;
}