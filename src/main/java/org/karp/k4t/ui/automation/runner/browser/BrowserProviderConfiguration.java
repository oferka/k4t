package org.karp.k4t.ui.automation.runner.browser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.automation.runner.browser.Browser.BrowserType.CHROME;

@Configuration
@PropertySource("classpath:browser-provider.properties")
@ConfigurationProperties(prefix = "browser")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrowserProviderConfiguration {

    @NotNull
    private Browser.BrowserType type = CHROME;

    private boolean maximizeWindow = false;

    private boolean headless = false;
}