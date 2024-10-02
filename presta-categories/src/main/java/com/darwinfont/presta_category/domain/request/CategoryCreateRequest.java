package com.darwinfont.presta_category.domain.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CategoryCreateRequest {
    @NotNull(message = "name is mandatory")
    @NotEmpty(message = "name is mandatory")
    private String name;
    @NotNull(message = "description id is mandatory")
    @NotEmpty(message = "description is mandatory")
    private String description;
    @NotNull(message = "parent id is mandatory")
    @Min(0)
    private Integer idParent;
    @NotNull(message = "active is mandatory")
    private Boolean active;
    @NotNull(message = "isRootCategory is mandatory")
    private Boolean isRootCategory;
    @NotNull(message = "linkRewrite is mandatory")
    @NotEmpty(message = "linkRewrite is mandatory")
    private String linkRewrite;
    @Length(max = 255, message = "meta_title must have a maximum of 255 characters.")
    private String metaTitle;
    @Length(max = 512, message = "metaDescription must have a maximum of 512 characters.")
    private String metaDescription;
}