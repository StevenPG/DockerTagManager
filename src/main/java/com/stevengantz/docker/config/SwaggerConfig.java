package com.stevengantz.docker.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket registryAPI() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.stevengantz.docker.controller"))
				.paths(regex("/api.*"))
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "DockerTagManager REST API",
                "DockerTagManager REST API for remote Docker registry viewing and tag comparisons",
                "1.0",
                "Terms of service",
                new Contact("Steven Gantz", "http://stevengantz.com", "steven.p.gantz@gmail.com"),
               "MIT License",
                "https://opensource.org/licenses/MIT");
        return apiInfo;
    }

}
