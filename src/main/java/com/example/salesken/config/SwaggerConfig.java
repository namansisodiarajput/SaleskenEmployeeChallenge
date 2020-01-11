package com.example.salesken.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * 
 * @author NamanSisodia
 * swagger config to show api information
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
  
  @Bean
  public Docket userAPI() {
      return new Docket(DocumentationType.SWAGGER_2)
              .select()
              .apis(RequestHandlerSelectors.basePackage("com.example.salesken.controller"))
              .paths(PathSelectors.any())              
              .build()
              .apiInfo(metaData());
  }
  private ApiInfo metaData() {
      return new ApiInfoBuilder()
              .title("Salesken API")
              .description("\"Salesken API for employees\"")
              .version("1.0.0")
              .license("Apache License Version 2.0")
              .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
              .contact(new Contact("Naman S", "https://salesken.com", "namansisodia619@gmail.com"))
              .build();
  }
  @Override
  protected void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("swagger-ui.html")
              .addResourceLocations("classpath:/META-INF/resources/");

      registry.addResourceHandler("/webjars/**")
              .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

}
