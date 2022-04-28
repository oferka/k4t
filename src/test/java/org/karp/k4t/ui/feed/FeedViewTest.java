package org.karp.k4t.ui.feed;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.karp.k4t.ui.automation.runner.browser.Browser;
import org.karp.k4t.ui.automation.runner.browser.BrowserProvider;
import org.karp.k4t.ui.automation.runner.driver.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
class FeedViewTest {

    @Autowired
    private BrowserProvider browserProvider;

    @Autowired
    private WebDriverProvider driverFactory;

    @BeforeAll
    public static void startApp() {
        SpringApplication.run(Application.class);
    }

    @Test
    public void test1() {
        Browser browser = browserProvider.get();
        WebDriver driver = driverFactory.get(browser);
        driver.get("http://localhost:8080");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}