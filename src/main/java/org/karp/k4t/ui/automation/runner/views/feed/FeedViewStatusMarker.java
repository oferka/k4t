package org.karp.k4t.ui.automation.runner.views.feed;

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
public class FeedViewStatusMarker {

    @NotNull
    private final ElementRetriever elementRetriever;

    @NotNull
    private final FeedViewElementLocatorProvider feedViewElementLocatorProvider;

    @NotNull
    private final ElementStatusMarker elementStatusMarker;

    public void mark(
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull ElementStatus elementStatus) {
        log.info("Marking status '{}' for feed view started", elementStatus.getName());
        elementStatusMarker.mark(
                driver,
                elementRetriever.getByPresence(
                        driver,
                        feedViewElementLocatorProvider.getControlsContainer()
                ),
                elementStatus
        );
        elementStatusMarker.mark(
                driver,
                elementRetriever.getByPresence(
                        driver,
                        feedViewElementLocatorProvider.getBackgroundContainer()
                ),
                elementStatus
        );
        log.info("Marking status '{}' for feed view completed", elementStatus.getName());
    }
}
