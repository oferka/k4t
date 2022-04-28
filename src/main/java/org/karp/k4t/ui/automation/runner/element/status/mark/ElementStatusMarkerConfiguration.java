package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Configuration
@PropertySource("classpath:element-status-marker.properties")
@ConfigurationProperties(prefix = "element.status.marker")
@Data
public class ElementStatusMarkerConfiguration {

    private boolean enabled = true;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String readyBorder = "1px solid Gainsboro";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String inProgressBorder = "3px double blue";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String passedBorder = "3px double green";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String failedBorder = "3px double red";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String noContentBorder = "3px double orange";

    @NotNull
    @NotBlank
    @Size(min = 2, max = 32)
    private String timedOutBorder = "3px double DarkRed";

    private boolean takeScreenshot = false;
}