package org.karp.k4t.ui.automation.runner.element.retrieve;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:element-retriever.properties")
@ConfigurationProperties(prefix = "element.retriever")
@Data
public class ElementRetrieverConfiguration {

    private long byPresenceDefaultTimeout = 30;
    private long byClickableDefaultTimeout = 30;
}