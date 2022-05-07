package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.actions.pause.ExecutionPauser;
import org.karp.k4t.ui.automation.runner.element.status.ElementStatus;
import org.karp.k4t.ui.automation.runner.info.screenshot.ScreenshotTaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Arrays.asList;
import static org.karp.k4t.ui.automation.runner.element.attribute.ElementAttribute.*;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class ElementBorderMarker {

    @NotNull
    private final ElementBorderMarkerConfiguration elementBorderMarkerConfiguration;

    @NotNull
    private final ScreenshotTaker screenshotTaker;

    @NotNull
    private final ExecutionPauser executionPauser;

    @NotNull
    private final ElementStyleAttributeGetter elementStyleAttributeGetter;

    @NotNull
    private final ElementStyleAttributeSetter elementStyleAttributeSetter;

    public void mark(
            @NotNull String flowName,
            @NotNull String executionId,
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull WebElement element,
            @Valid @NotNull ElementStatus elementStatus) {
        log.info("Marking border '{}' for element started", elementStatus.getName());
        if(elementBorderMarkerConfiguration.isEnabled()) {
            try {
                String currentBorderStyle = elementStyleAttributeGetter.get(element, BORDER_STYLE);
                String currentBorderWidth = elementStyleAttributeGetter.get(element, BORDER_WIDTH);
                String currentBorderColor = elementStyleAttributeGetter.get(element, BORDER_COLOR);

                List<StyleAttributeKeyValue> markStyleAttributeKeyValues = asList(
                        new StyleAttributeKeyValue(BORDER_STYLE, BORDER_STYLE.getValue(elementStatus)),
                        new StyleAttributeKeyValue(BORDER_WIDTH, BORDER_WIDTH.getValue(elementStatus)),
                        new StyleAttributeKeyValue(BORDER_COLOR, BORDER_COLOR.getValue(elementStatus))
                );
                elementStyleAttributeSetter.set(driver, element, markStyleAttributeKeyValues);

                executionPauser.pause();
                screenshotTaker.take(flowName, executionId, driver, elementBorderMarkerConfiguration.isTakeScreenshot());

                List<StyleAttributeKeyValue> currentStyleAttributeKeyValues = asList(
                        new StyleAttributeKeyValue(BORDER_STYLE, currentBorderStyle),
                        new StyleAttributeKeyValue(BORDER_WIDTH, currentBorderWidth),
                        new StyleAttributeKeyValue(BORDER_COLOR, currentBorderColor)
                );
                elementStyleAttributeSetter.set(driver, element, currentStyleAttributeKeyValues);
            }
            catch (Exception e) {
                log.error("Marking border '{}' for element failed. Error message is '{}'", elementStatus.getName(), e.getMessage());
            }
        }
        else {
            log.info("Element border marker is not enabled");
        }
        log.info("Marking border '{}' for element completed", elementStatus.getName());
    }
}
