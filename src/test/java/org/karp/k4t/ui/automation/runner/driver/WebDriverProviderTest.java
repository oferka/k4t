package org.karp.k4t.ui.automation.runner.driver;

import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.karp.k4t.ui.automation.runner.browser.Browser;
import org.karp.k4t.ui.automation.runner.browser.BrowserProvider;
import org.karp.k4t.ui.automation.runner.browser.BrowserProviderConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.karp.k4t.ui.automation.runner.browser.Browser.BrowserType.CHROME;
import static org.karp.k4t.ui.automation.runner.browser.Browser.BrowserType.FIREFOX;

@SpringBootTest(classes = Application.class)
class WebDriverProviderTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider driverFactory;

    @Test
    public void shouldGetDefault() {
        Browser browser = browserProvider.get();
        WebDriver driver = driverFactory.get(browser);
        verifyAndQuitWebDriver(driver);

    }

    @Test
    public void shouldGetChrome() {
        BrowserProviderConfiguration configuration = new BrowserProviderConfiguration();
        configuration.setType(CHROME);
        configuration.setHeadless(false);
        Browser browser = browserProvider.get(configuration);
        WebDriver driver = driverFactory.get(browser);
        verifyAndQuitWebDriver(driver);
    }

    @Test
    public void shouldGetChromeHeadless() {
        BrowserProviderConfiguration configuration = new BrowserProviderConfiguration();
        configuration.setType(CHROME);
        configuration.setHeadless(true);
        Browser browser = browserProvider.get(configuration);
        WebDriver driver = driverFactory.get(browser);
        verifyAndQuitWebDriver(driver);
    }

    @Test
    public void shouldGetFirefox() {
        BrowserProviderConfiguration configuration = new BrowserProviderConfiguration();
        configuration.setType(FIREFOX);
        configuration.setHeadless(false);
        Browser browser = browserProvider.get(configuration);
        WebDriver driver = driverFactory.get(browser);
        verifyAndQuitWebDriver(driver);
    }

    @Test
    public void shouldGetFirefoxHeadless() {
        BrowserProviderConfiguration configuration = new BrowserProviderConfiguration();
        configuration.setType(FIREFOX);
        configuration.setHeadless(true);
        Browser browser = browserProvider.get(configuration);
        WebDriver driver = driverFactory.get(browser);
        verifyAndQuitWebDriver(driver);
    }

    private void verifyAndQuitWebDriver(@NotNull WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/");
        String title = driver.getTitle();
        assertEquals("The Internet", title);
        driver.quit();
    }
}