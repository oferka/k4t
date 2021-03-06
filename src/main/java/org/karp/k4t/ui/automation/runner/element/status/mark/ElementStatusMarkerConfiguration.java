package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:element-status-marker.properties")
@ConfigurationProperties(prefix = "element.status.marker")
@Data
public class ElementStatusMarkerConfiguration {

    private boolean enabled = true;

    private boolean takeScreenshot = false;
}