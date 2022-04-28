package org.karp.k4t.ui.automation.runner.element.retrieve;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Duration;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class ElementRetriever {

    @NotNull
    private final ElementRetrieverConfiguration elementRetrieverConfiguration;

    public @NotNull WebElement getByPresence(@Valid @NotNull WebDriver driver, @Valid @NotNull By locator, long timeOutInSeconds) {
        return retrieve(driver, timeOutInSeconds, ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    public @NotNull WebElement getByPresence(@Valid @NotNull WebDriver driver, @Valid @NotNull By locator) {
        return getByPresence(driver, locator, elementRetrieverConfiguration.getByPresenceDefaultTimeout());
    }

    public @NotNull WebElement getByClickable(@Valid @NotNull WebDriver driver, @Valid @NotNull By locator, long timeOutInSeconds) {
        return retrieve(driver, timeOutInSeconds, ExpectedConditions.elementToBeClickable(locator));
    }

    public @NotNull WebElement getByClickable(@Valid @NotNull WebDriver driver, @Valid @NotNull By locator) {
        return getByClickable(driver, locator, elementRetrieverConfiguration.getByClickableDefaultTimeout());
    }

    private @NotNull WebElement retrieve(@Valid @NotNull WebDriver driver, long timeOutInSeconds, @Valid @NotNull ExpectedCondition<WebElement> expectedCondition) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)).until(expectedCondition);
    }
}
