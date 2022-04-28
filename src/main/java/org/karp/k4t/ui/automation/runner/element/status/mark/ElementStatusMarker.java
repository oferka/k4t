package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.element.status.ElementStatus;
import org.karp.k4t.ui.automation.runner.info.screenshot.ScreenshotTaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class ElementStatusMarker {

    @NotNull
    private final ElementStatusMarkerConfiguration elementStatusMarkerConfiguration;

    @NotNull
    private final ElementBorderMarker elementBorderMarker;

    @NotNull
    private final ScreenshotTaker screenshotTaker;

    private void mark(
            @NotNull String flowName,
            @NotNull String executionId,
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull WebElement element,
            @Valid @NotNull ElementStatus elementStatus,
            boolean pause) {
        log.info("Marking status '{}' for element started", elementStatus.getName());
        if(elementStatusMarkerConfiguration.isEnabled()) {
            try {
                String borderValue = generateBorderValue(elementStatus);
                elementBorderMarker.mark(driver, element, borderValue, pause);
                screenshotTaker.take(flowName, executionId, driver, elementStatusMarkerConfiguration.isTakeScreenshot());
            }
            catch (Exception e) {
                log.error("Marking status '{}' for element failed. Error message is '{}'", elementStatus.getName(), e.getMessage());
            }
        }
        else {
            log.info("Element status marker is not enabled");
        }
        log.info("Marking status '{}' for element completed", elementStatus.getName());
    }

    private void mark(
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull WebElement element,
            @Valid @NotNull ElementStatus elementStatus,
            boolean pause) {
        mark(EMPTY, UUID.randomUUID().toString(), driver, element, elementStatus, pause);
    }

    public void mark(
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull WebElement element,
            @Valid @NotNull ElementStatus elementStatus) {
        mark(driver, element, elementStatus, true);
    }

    private @NotNull String generateBorderValue(@Valid @NotNull ElementStatus elementStatus) {
        String result = null;
        switch (elementStatus) {
            case READY:
                result = elementStatusMarkerConfiguration.getReadyBorder();
                break;
            case IN_PROGRESS:
                result = elementStatusMarkerConfiguration.getInProgressBorder();
                break;
            case PASSED:
                result = elementStatusMarkerConfiguration.getPassedBorder();
                break;
            case FAILED:
                result = elementStatusMarkerConfiguration.getFailedBorder();
                break;
            case NO_CONTENT:
                result = elementStatusMarkerConfiguration.getNoContentBorder();
                break;
            case TIMED_OUT:
                result = elementStatusMarkerConfiguration.getTimedOutBorder();
                break;
        }
        return result;
    }
}
