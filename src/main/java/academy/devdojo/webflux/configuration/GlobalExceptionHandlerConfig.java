package academy.devdojo.webflux.configuration;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalExceptionHandlerConfig {
    @Bean
    public WebProperties.Resources resources() {
        return new WebProperties.Resources();
    }
}
