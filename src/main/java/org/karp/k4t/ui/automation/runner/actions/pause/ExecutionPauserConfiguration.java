package org.karp.k4t.ui.automation.runner.actions.pause;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.PositiveOrZero;

@Configuration
@PropertySource("classpath:execution-pause.properties")
@ConfigurationProperties(prefix = "execution.pause")
@Data
public class ExecutionPauserConfiguration {

    private boolean enabled = false;

    @PositiveOrZero
    private long defaultDelayInMillis = 50;
}