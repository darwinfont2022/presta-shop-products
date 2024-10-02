package com.darwinfont.presta_products.setting;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.http.codec.xml.Jaxb2XmlEncoder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
public class WebClientConfig {

    private final PropertyConfig propertyConfig;

    @Bean(name = "jsonRequest")
    public WebClient settingPrestashopWebClient() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Output-Format", "JSON");
        headers.setBasicAuth(propertyConfig.getApiKey(), "");

        return WebClient.builder()
                .baseUrl(propertyConfig.getUrl())
                .defaultHeaders(
                        header -> header.addAll(headers)
                )
                .build();
    }

    @Bean(name = "xmlRequest")
    public WebClient settingXMLRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Output-Format", "JSON");
        headers.setBasicAuth(propertyConfig.getApiKey(), "");

        return WebClient.builder()
                .baseUrl(propertyConfig.getUrl())
                .defaultHeaders(header -> header.addAll(headers))
                .codecs(configure -> {
                    configure.defaultCodecs().jaxb2Encoder(new Jaxb2XmlEncoder());
                    configure.defaultCodecs().jaxb2Decoder(new Jaxb2XmlDecoder());
                    return;
                })
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
                .build();
    }

    @Bean(name = "formDataWebClient")
    public WebClient settingFormDataWebClient() {
        HttpHeaders headers = new HttpHeaders();

        headers.add("Output-Format", "JSON");
        headers.setBasicAuth(propertyConfig.getApiKey(), "");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        return WebClient.builder()
                .baseUrl(propertyConfig.getUrl())
                .defaultHeaders(
                        header -> header.addAll(headers)
                )
                .build();
    }
}