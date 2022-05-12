package org.karp.k4t.ui.automation.runner.views.quizzes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.element.retrieve.ElementRetriever;
import org.karp.k4t.ui.automation.runner.element.status.ElementStatus;
import org.karp.k4t.ui.automation.runner.element.status.mark.ElementStatusMarker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class QuizzesViewStatusMarker {

    @NotNull
    private final ElementRetriever elementRetriever;

    @NotNull
    private final QuizzesViewElementLocatorProvider quizzesViewElementLocatorProvider;

    @NotNull
    private final ElementStatusMarker elementStatusMarker;

    public void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull ElementStatus elementStatus) {
        log.info("Marking status '{}' for quizzes view started", elementStatus.getName());
        List<By> locators = asList(
                quizzesViewElementLocatorProvider.getControlsContainer()
        );
        mark(driver, locators, elementStatus);
        log.info("Marking status '{}' for quizzes view completed", elementStatus.getName());
    }

    private void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull List<By> locators, @Valid @NotNull ElementStatus elementStatus) {
        for (By locator : locators) {
            mark(driver, locator, elementStatus);
        }
    }

    private void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull By locator, @Valid @NotNull ElementStatus elementStatus) {
        mark(driver, elementRetriever.getByPresence(driver, locator), elementStatus);
    }

    private void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull WebElement element, @Valid @NotNull ElementStatus elementStatus) {
        elementStatusMarker.mark(driver, element, elementStatus);
    }
}
