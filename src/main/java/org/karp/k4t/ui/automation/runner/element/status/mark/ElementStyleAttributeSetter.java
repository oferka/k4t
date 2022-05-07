package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class ElementStyleAttributeSetter {

    @NotNull
    private final ElementStyleAttributeScriptGenerator elementStyleAttributeScriptGenerator;

    public void set(
            @Valid @NotNull WebDriver driver,
            @Valid @NotNull WebElement element,
            @Valid @NotNull List<StyleAttributeKeyValue> styleAttributeKeyValues) {
        log.info("Setting element style attribute to '{}' started", styleAttributeKeyValues);
        String script = elementStyleAttributeScriptGenerator.generate(styleAttributeKeyValues);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript(script, element);
        }
        catch (Exception e) {
            log.error("Failed to set element style attribute to '{}'. Executed script was: '{}'", styleAttributeKeyValues, script);
        }
        log.info("Setting element style attribute to '{}' completed", styleAttributeKeyValues);
    }
}
