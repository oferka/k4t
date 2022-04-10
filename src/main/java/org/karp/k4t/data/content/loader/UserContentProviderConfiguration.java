package org.karp.k4t.data.content.loader;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Positive;

@Configuration
@PropertySource("classpath:user-content-provider-configuration.properties")
@ConfigurationProperties(prefix = "user.content.provider")
@Data
public class UserContentProviderConfiguration {

    @Positive
    private Integer numberOfItems = 500;
}
