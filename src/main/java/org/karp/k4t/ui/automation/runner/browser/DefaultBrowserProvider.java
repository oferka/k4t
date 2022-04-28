package org.karp.k4t.ui.automation.runner.browser;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class DefaultBrowserProvider implements BrowserProvider {

    @NotNull
    private final BrowserProviderConfiguration configuration;

    @Override
    public @NotNull Browser get() {
        return get(configuration);
    }

    @Override
    public Browser get(BrowserProviderConfiguration configuration) {
        log.info("Get browser with configuration {} started", configuration);
        Browser browser = new Browser(
                configuration.getType(),
                configuration.isMaximizeWindow(),
                configuration.isHeadless()
        );
        validate(browser);
        log.info("Get browser with configuration {} completed", configuration);
        return browser;
    }

    private void validate(@NotNull Browser browser) {
        log.info("Validation for '{}' started", browser);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Browser>> violations = validator.validate(browser);
        if (!violations.isEmpty()) {
            log.error("Validation for '{}' completed with {} violations: {}", browser, violations.size(), violations);
            throw new ConstraintViolationException(violations);
        }
        log.info("Validation for '{}' completed successfully. No constraint violations were found", browser);
    }
}