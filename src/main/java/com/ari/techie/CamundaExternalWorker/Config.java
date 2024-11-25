package com.ari.techie.CamundaExternalWorker;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Bean("restTemplate")
    public RestTemplate getRestTemplate(){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        RestTemplate restTemplate =builder.build();
        return restTemplate;
    }
}
