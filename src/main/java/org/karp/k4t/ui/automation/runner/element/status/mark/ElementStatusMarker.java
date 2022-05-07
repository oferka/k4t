package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.element.status.ElementStatus;
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

    private void mark(
            @NotNull String flowName,
            @NotNull String executionId,
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull WebElement element,
            @Valid @NotNull ElementStatus elementStatus) {
        log.info("Marking status '{}' for element started", elementStatus.getName());
        if(elementStatusMarkerConfiguration.isEnabled()) {
            elementBorderMarker.mark(flowName, executionId, driver, element, elementStatus);
        }
        else {
            log.info("Element status marker is not enabled");
        }
        log.info("Marking status '{}' for element completed", elementStatus.getName());
    }

    public void mark(
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull WebElement element,
            @Valid @NotNull ElementStatus elementStatus) {
        mark(EMPTY, UUID.randomUUID().toString(), driver, element, elementStatus);
    }
}
