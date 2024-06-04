package org.question1.question1calculator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfiguration {
    @Bean
    public RestClient restClient() {

        return RestClient.create();
    }
}
