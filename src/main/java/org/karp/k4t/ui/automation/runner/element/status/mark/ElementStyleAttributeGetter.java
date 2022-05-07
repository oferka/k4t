package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.element.attribute.ElementAttribute;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class ElementStyleAttributeGetter {

    public @NotNull String get(@Valid @NotNull WebElement element, @Valid @NotNull @NotBlank @Size(min = 2, max = 32) String attributeName) {
        log.info("Getting element style attribute '{}' started", attributeName);
        String result = element.getCssValue(attributeName);
        log.info("Getting element style attribute '{}' completed. Value is: '{}'", attributeName, result);
        return result;
    }

    public @NotNull String get(@Valid @NotNull WebElement element, @Valid ElementAttribute elementAttribute) {
        return get(element, elementAttribute.getName());
    }
}
