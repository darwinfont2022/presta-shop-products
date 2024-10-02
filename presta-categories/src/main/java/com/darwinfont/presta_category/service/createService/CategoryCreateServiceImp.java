package com.darwinfont.presta_category.service.createService;

import com.darwinfont.presta_category.domain.mapper.CategoryMapper;
import com.darwinfont.presta_category.domain.request.CategoryCreateRequest;
import com.darwinfont.presta_category.domain.request.PrestaCategoryRoot;
import com.darwinfont.presta_category.domain.response.category.PrestaCategoryResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CategoryCreateServiceImp implements CategoryCreateService {
    private final WebClient xmlWebClient;
    private final String CATEGORY_URL = "/categories";

    public CategoryCreateServiceImp(@Qualifier("xmlRequest") WebClient xmlWebClient) {
        this.xmlWebClient = xmlWebClient;
    }

    @Override
    public Mono<PrestaCategoryResponse> createCategory(CategoryCreateRequest categoryCreateRequest) {
        PrestaCategoryRoot prestaCategoryRoot = CategoryMapper.createPrestaCategory(categoryCreateRequest, null);

        return xmlWebClient.post()
                .uri(CATEGORY_URL)
                .body(BodyInserters.fromValue(prestaCategoryRoot))
                .retrieve()
                .bodyToMono(PrestaCategoryResponse.class);
    }
}