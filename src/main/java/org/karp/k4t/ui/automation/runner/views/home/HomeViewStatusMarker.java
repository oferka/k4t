package org.karp.k4t.ui.automation.runner.views.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.element.retrieve.ElementRetriever;
import org.karp.k4t.ui.automation.runner.element.status.ElementStatus;
import org.karp.k4t.ui.automation.runner.element.status.mark.ElementStatusMarker;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class HomeViewStatusMarker {

    @NotNull
    private final ElementRetriever elementRetriever;

    @NotNull
    private final HomeViewElementLocatorProvider homeViewElementLocatorProvider;

    @NotNull
    private final ElementStatusMarker elementStatusMarker;

    public void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull ElementStatus elementStatus) {
        log.info("Marking status '{}' for home view started", elementStatus.getName());
        elementStatusMarker.mark(
                driver,
                elementRetriever.getByPresence(
                        driver,
                        homeViewElementLocatorProvider.getControlsContainer()
                ),
                elementStatus
        );
        elementStatusMarker.mark(
                driver,
                elementRetriever.getByPresence(
                        driver,
                        homeViewElementLocatorProvider.getBackgroundContainer()
                ),
                elementStatus
        );
        log.info("Marking status '{}' for home view completed", elementStatus.getName());
    }
}
