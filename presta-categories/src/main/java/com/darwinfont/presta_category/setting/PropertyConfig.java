package com.darwinfont.presta_category.setting;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PropertyConfig {
    @Value("${prestashop.url}")
    private String url;

    @Value("${prestashop.api_key}")
    private String apiKey;
}
