package dev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ApiVersionConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
     * path-segment /v1/users
     * request header
     * query param
     * media type param
     */
    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer.addSupportedVersions("1.0.0", "1.1.0", "2.0.0")
                .setDefaultVersion("1.0.0")
                .usePathSegment(1)
                .setVersionParser(new CustomApiVersionParser());
    }

}
