package dio.web.api.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contato(){
        return new Contact(
            "Seu nome",
            "http://www.seusite.com.br",
            "voce@seusite.com.br");
    }

    private ApiInfoBuilder informacoesApi(){
        ApiInfoBuilder ApiInfoBuilder = new ApiInfoBuilder();

        ApiInfoBuilder.title("Title - Rest API");
        ApiInfoBuilder.description("API exemplo de uso de Springboot REST API");
        ApiInfoBuilder.version("1.0");
        ApiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        ApiInfoBuilder.license("Licença - Sua Empresa");
        ApiInfoBuilder.licenseUrl("http://www.seusite.com.br");
        ApiInfoBuilder.contact(this.contato());

        return ApiInfoBuilder;
    }
    @Bean
    public Docket detalheApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("dio.web.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<>(Arrays.asList("application/json")))
                .produces(new HashSet<>(Arrays.asList("application/json")));

        return docket;


    }
}
