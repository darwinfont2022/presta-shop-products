package com.darwinfont.presta_category.service.loadService;

import com.darwinfont.presta_category.domain.response.category.CategoryListResponse;
import com.darwinfont.presta_category.domain.response.category.PrestaCategoryResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CategoryLoadService {
    Mono<List<String>> availableFilters();
    Mono<CategoryListResponse> categoryFilter(
            String name, List<Integer> ids,
            String filter, String filter_value
    );
    Mono<PrestaCategoryResponse> findCategoryDetail(Integer id);
}
