package com.mper.smartschool.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.mper.smartschool.config.MessageConfig.REQUEST_PARAM_LANGUAGE_NAME;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mper.smartschool"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(Lists.newArrayList(language()));
    }


    private Parameter language() {
        return new ParameterBuilder()
                .name(REQUEST_PARAM_LANGUAGE_NAME)
                .description("Language")
                .modelRef(new ModelRef("string"))
                .parameterType("query")
                .required(true)
                .allowableValues(new AllowableListValues(Lists.newArrayList("en", "uk"), "string"))
                .build();
    }

}
