package com.darwinfont.presta_products.service.image;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ImageServiceImp implements ImageService {
    private final WebClient formDataWebClient;
    private final WebClient jsonWebClient;
    private final String IMAGE_URL = "/images/products/";

    public ImageServiceImp(@Qualifier("formDataWebClient") WebClient formDataWebClient,
                           @Qualifier("jsonRequest") WebClient jsonWebClient) {
        this.formDataWebClient = formDataWebClient;
        this.jsonWebClient = jsonWebClient;
    }

    @Override
    public Mono<?> upload(Integer id, MultipartFile image) {
        MultiValueMap<String, Object> formData = new LinkedMultiValueMap<>();

        formData.add("image", image.getResource());

        return formDataWebClient.post()
                .uri(IMAGE_URL + id)
                .body(BodyInserters.fromMultipartData(formData))
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(prestaRes -> Mono.empty());
    }
}
