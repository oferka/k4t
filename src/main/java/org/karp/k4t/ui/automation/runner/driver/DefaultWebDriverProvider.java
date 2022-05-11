package org.karp.k4t.ui.automation.runner.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.browser.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Service
@Slf4j
@Validated
public class DefaultWebDriverProvider implements WebDriverProvider {

    @Override
    public @NotNull WebDriver get(@Valid @NotNull Browser browser) {
        log.info("Web driver creation started");
        WebDriver driver = null;
        switch (browser.getType()) {
            case CHROME:
                driver = createChromeDriver(browser);
                break;
            case FIREFOX:
                driver = createFirefoxDriver(browser);
                break;
        }
        if(browser.isMaximize()) {
            maximizeWindow(driver);
        }
        validate(driver);
        log.info("Web driver creation completed");
        return driver;
    }

    private WebDriver createChromeDriver(Browser browser) {
        log.info("Chrome web driver creation started");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(browser.isHeadless());
        WebDriver result = new ChromeDriver(chromeOptions);
        log.info("Chrome web driver creation completed");
        return result;
    }

    private WebDriver createFirefoxDriver(Browser browser) {
        log.info("Firefox web driver creation started");
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(browser.isHeadless());
        WebDriver result = new FirefoxDriver(firefoxOptions);
        log.info("Firefox web driver creation completed");
        return result;
    }

    private void maximizeWindow(@Valid @NotNull WebDriver driver) {
        log.info("Browser window maximize started");
        driver.manage().window().maximize();
        log.info("Browser window maximize completed");
    }

    private void validate(@NotNull WebDriver driver) {
        log.info("Validation for '{}' started", driver);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<WebDriver>> violations = validator.validate(driver);
        if (!violations.isEmpty()) {
            log.error("Validation for '{}' completed with {} violations: {}", driver, violations.size(), violations);
            throw new ConstraintViolationException(violations);
        }
        log.info("Validation for '{}' completed successfully. No constraint violations were found", driver);
    }
}