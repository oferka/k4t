package org.karp.k4t.ui.feed;

import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.karp.k4t.ui.automation.runner.browser.Browser;
import org.karp.k4t.ui.automation.runner.browser.BrowserProvider;
import org.karp.k4t.ui.automation.runner.browser.BrowserProviderConfiguration;
import org.karp.k4t.ui.automation.runner.driver.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.karp.k4t.ui.automation.runner.browser.Browser.BrowserType.CHROME;
import static org.karp.k4t.ui.automation.runner.browser.Browser.BrowserType.FIREFOX;

@SpringBootTest(classes = Application.class)
class FeedViewTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider driverFactory;

    @Test
    public void test1() {
        Browser browser = browserProvider.get();
        WebDriver driver = driverFactory.get(browser);
        driver.get("https://www.fiverr.com/");
        driver.quit();

    }

    @Test
    public void test2() {
        BrowserProviderConfiguration configuration = new BrowserProviderConfiguration(FIREFOX, false, false);
        Browser browser = browserProvider.get(configuration);
        WebDriver driver = driverFactory.get(browser);
        driver.get("https://www.fiverr.com/");
        driver.quit();
    }

    @Test
    public void test3() {
        BrowserProviderConfiguration configuration = new BrowserProviderConfiguration(CHROME, true, false);
        Browser browser = browserProvider.get(configuration);
        WebDriver driver = driverFactory.get(browser);
        driver.get("https://www.fiverr.com/");
        driver.quit();
    }

    @Test
    public void test4() {
        BrowserProviderConfiguration configuration = new BrowserProviderConfiguration(FIREFOX, true, true);
        Browser browser = browserProvider.get(configuration);
        WebDriver driver = driverFactory.get(browser);
        driver.get("https://www.fiverr.com/");
        driver.quit();
    }
}