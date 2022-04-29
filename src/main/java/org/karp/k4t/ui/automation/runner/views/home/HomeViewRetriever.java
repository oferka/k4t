package org.karp.k4t.ui.automation.runner.views.home;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Duration;

import static org.karp.k4t.ui.home.HomeView.NAME;

@Service
@Slf4j
@Validated
public class HomeViewRetriever {

    public void get(@Valid @NotNull WebDriver driver, long timeOutInSeconds) {
        log.info("Retrieve home view started. Timeout is set to {} seconds", timeOutInSeconds);
        new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)).until(ExpectedConditions.titleContains(NAME));
        log.info("Retrieve home view page completed");
    }
}
