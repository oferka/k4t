package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.actions.pause.ExecutionPauser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class ElementBorderMarker {

    @NotNull
    private final ExecutionPauser executionPauser;

    public void mark(
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull WebElement element,
            @Valid @NotNull @NotBlank @Size(min = 2, max = 32) String borderValue,
            boolean pause) {
        log.info("Marking element border to be '{}' started", borderValue);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = format("arguments[0].setAttribute('style', 'border: %s;');", borderValue);
        js.executeScript(script, element);
        if(pause) {
            executionPauser.pause();
        }
        log.info("Marking element border to be '{}' completed", borderValue);
    }
}
