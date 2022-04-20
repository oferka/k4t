package org.karp.k4t.data.content.loader.search.term;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.PositiveOrZero;

@Configuration
@PropertySource("classpath:search-term-content-provider-configuration.properties")
@ConfigurationProperties(prefix = "search.term.content.provider")
@Data
public class SearchTermContentProviderConfiguration {

    @PositiveOrZero
    private Integer numberOfItems = 100;
}
