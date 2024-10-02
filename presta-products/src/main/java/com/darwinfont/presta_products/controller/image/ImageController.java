package com.darwinfont.presta_products.controller.image;

import com.darwinfont.presta_products.service.image.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public Mono<?> uploadImage(
            @RequestParam Integer id,
            @RequestPart("image") MultipartFile image
    ){
        return imageService.upload(id, image);
    }
}
