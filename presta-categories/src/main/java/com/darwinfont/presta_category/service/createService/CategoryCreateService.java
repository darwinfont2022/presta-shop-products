package com.darwinfont.presta_category.service.createService;

import com.darwinfont.presta_category.domain.request.CategoryCreateRequest;
import com.darwinfont.presta_category.domain.response.category.PrestaCategoryResponse;
import reactor.core.publisher.Mono;

public interface CategoryCreateService {
    Mono<PrestaCategoryResponse> createCategory(CategoryCreateRequest categoryCreateRequest);

}
