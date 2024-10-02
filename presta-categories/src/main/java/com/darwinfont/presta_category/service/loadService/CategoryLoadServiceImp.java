package com.darwinfont.presta_category.service.loadService;

import com.darwinfont.presta_category.domain.response.category.CategoryListResponse;
import com.darwinfont.presta_category.domain.response.category.CategoryResponse;
import com.darwinfont.presta_category.domain.response.category.PrestaCategoryResponse;
import com.darwinfont.presta_category.exceptions.BadRequestException;
import com.darwinfont.presta_category.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryLoadServiceImp implements CategoryLoadService{
    private final WebClient jsonWebClient;
    private final String CATEGORY_URL = "/categories";

    public CategoryLoadServiceImp(@Qualifier("jsonRequest") WebClient jsonWebClient) {
        this.jsonWebClient = jsonWebClient;
    }



    @Override
    public Mono<List<String>> availableFilters() {
        var filters = Arrays.stream(CategoryResponse.class.getDeclaredFields()).toList().stream().map(Field::getName).toList();
        return Mono.just(filters);
    }

    @Override
    public Mono<CategoryListResponse> categoryFilter(String name, List<Integer> ids, String filter, String filter_value) {

        return jsonWebClient.get()
                .uri(uriBuilder -> {
                            if (name != null && !name.isEmpty()) {
                                uriBuilder.queryParam("filter[name]", name);
                            }

                            if (ids != null && !ids.isEmpty()) {
                                uriBuilder.queryParam("filter[id]", "["
                                        + String.join("|", ids.stream().map(Object::toString).toList())
                                        + "]"
                                );
                            }

                            if ((filter != null && filter_value != null)) {
                                if (filter.isEmpty() || filter_value.isEmpty()) {
                                    throw new BadRequestException("filter or filter_value can't empty");
                                }

                                uriBuilder.queryParam("filter[" + filter + "]", filter_value);
                            }

                            return uriBuilder
                                    .path(CATEGORY_URL)
                                    .queryParam("output_format", "JSON")
                                    .queryParam("display", "full")
                                    .build();
                        }
                )
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().equals(HttpStatus.OK)) {
                        Mono<CategoryListResponse> response = clientResponse
                                .bodyToMono(CategoryListResponse.class)
                                .doOnError(throwable -> {
                                    throw new NotFoundException("category not found", 20);
                                }).map(rsp -> {
                                    rsp.setSize(rsp.getCategories().size());
                                    rsp.setFilter(filter);
                                    rsp.setFilter_value(filter_value);

                                    return rsp;
                                });

                        return response;
                    }
                    throw new NotFoundException("category not found", 20);
                });
    }

    @Override
    public Mono<PrestaCategoryResponse> findCategoryDetail(Integer id) {
        return null;
    }
}
