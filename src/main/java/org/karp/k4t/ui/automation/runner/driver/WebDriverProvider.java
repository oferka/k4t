package org.karp.k4t.ui.automation.runner.driver;

import org.karp.k4t.ui.automation.runner.browser.Browser;
import org.openqa.selenium.WebDriver;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface WebDriverProvider {

    @NotNull WebDriver get(@Valid @NotNull Browser browser);
}
