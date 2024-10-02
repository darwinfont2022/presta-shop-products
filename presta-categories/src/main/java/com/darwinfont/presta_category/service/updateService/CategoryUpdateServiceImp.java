package com.darwinfont.presta_category.service.updateService;

import com.darwinfont.presta_category.domain.mapper.CategoryMapper;
import com.darwinfont.presta_category.domain.request.CategoryUpdateRequest;
import com.darwinfont.presta_category.domain.request.PrestaCategoryRoot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CategoryUpdateServiceImp implements CategoryUpdateService {
    private final WebClient webClient;

    public CategoryUpdateServiceImp(@Qualifier("xmlRequest") WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<?> updateCategory(CategoryUpdateRequest updateDto, Integer id) {
        PrestaCategoryRoot body = CategoryMapper.updateMapperCategory(updateDto, id);

        return webClient.put()
                .uri("/categories/" + id)
                .bodyValue(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(String.class);
    }
}