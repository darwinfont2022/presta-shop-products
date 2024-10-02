package com.darwinfont.presta_category.service.updateService;

import com.darwinfont.presta_category.domain.request.CategoryUpdateRequest;
import reactor.core.publisher.Mono;

public interface CategoryUpdateService {
    Mono<?> updateCategory(CategoryUpdateRequest updateDto, Integer id);
}