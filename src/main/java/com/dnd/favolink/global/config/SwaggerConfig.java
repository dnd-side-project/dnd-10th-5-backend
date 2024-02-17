package com.dnd.favolink.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "📝 Favolink API 명세서",
                description = "favolink 서비스의 API 명세서입니다.",
                version = "v1"))
@Configuration
public class SwaggerConfig {
}
