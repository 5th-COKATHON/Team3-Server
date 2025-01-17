package com.cotato._th_cokathon.team3.common.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@OpenAPIDefinition(
	info = @Info(title = "Cokathon Team 3 API 명세서",
		description = "Cokathon Team 3 API 명세서",
		version = "v1")
)
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {

		return new OpenAPI()
			.addServersItem(new Server().url("http://localhost:8080").description("Local Server"))
			.addServersItem(new Server().url("https://snap-chain.kro.kr").description("Production Server"))
			.addServersItem(new Server().url("http://13.209.40.241:8080").description("Ec2 Server"));
	}

	@Bean
	public GroupedOpenApi chatOpenApi() {
		String[] paths = {"/api/**"};

		return GroupedOpenApi.builder()
			.group("스웨거 테스트 API v1")
			.pathsToMatch(paths)
			.build();
	}
}