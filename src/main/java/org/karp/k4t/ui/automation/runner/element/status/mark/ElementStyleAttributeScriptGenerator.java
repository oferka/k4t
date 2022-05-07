package org.karp.k4t.ui.automation.runner.element.status.mark;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class ElementStyleAttributeScriptGenerator {

    public @NotNull String generate(@Valid @NotNull List<StyleAttributeKeyValue> styleAttributeKeyValues) {
        log.info("Generate style attribute script for '{}' started", styleAttributeKeyValues);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("arguments[0].setAttribute('style', '");
        for(StyleAttributeKeyValue styleAttributeKeyValue : styleAttributeKeyValues) {
            stringBuilder.append(format("%s: %s;", styleAttributeKeyValue.getKey(), styleAttributeKeyValue.getValue()));
        }
        stringBuilder.append("');");
        String result = stringBuilder.toString();
        log.info("Generate style attribute script for '{}' completed. Generated script is '{}'", styleAttributeKeyValues, result);
        return result;
    }
}
