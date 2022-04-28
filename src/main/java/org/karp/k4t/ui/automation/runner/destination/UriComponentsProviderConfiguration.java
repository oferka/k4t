package org.karp.k4t.ui.automation.runner.destination;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotNull;

@Configuration
@PropertySource("classpath:uri-components.properties")
@ConfigurationProperties(prefix = "uri.component")
@Data
public class UriComponentsProviderConfiguration {

    @NotNull
    private String schema = "http";

    @NotNull
    private String host = "localhost";

    private int port = 8080;
}