package com.johnxb.questionnaire;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Configuration
@EnableSwagger2
@MapperScan("com.johnxb.questionnaire.dao")
public class QuestionnaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireApplication.class, args);
	}
	@Bean
	public Docket testApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.genericModelSubstitutes(DeferredResult.class)
				.useDefaultResponseMessages(false)
				.forCodeGeneration(true)
				.pathMapping("/")// base，最终调用接口后会和paths拼接在一起
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.johnxb.questionnaire.api"))
				.build();
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("问卷网站后台Api")
				.description("问卷网站Api文档")
				.termsOfServiceUrl("")
				.version("1.0")
				.build();
	}
}
