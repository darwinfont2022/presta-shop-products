package com.darwinfont.presta_products.service.image;

import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

public interface ImageService {
    Mono<?> upload(Integer resource_id, MultipartFile image);
}
