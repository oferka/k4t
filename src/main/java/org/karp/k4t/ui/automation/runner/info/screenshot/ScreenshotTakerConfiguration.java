package org.karp.k4t.ui.automation.runner.info.screenshot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:screenshot-taker.properties")
@ConfigurationProperties(prefix = "screenshot.taker")
@Data
public class ScreenshotTakerConfiguration {

    private boolean enabled = true;
}
