package com.darwinfont.presta_category.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssociationsResponse {
    private List<IdReferenceDto> categories;
    private List<IdReferenceDto> products;
}
