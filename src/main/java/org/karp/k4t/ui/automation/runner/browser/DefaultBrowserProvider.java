package org.karp.k4t.ui.automation.runner.browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DefaultBrowserProvider implements BrowserProvider {

    @Autowired
    @NotNull
    private BrowserProviderConfiguration configuration;

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

//    @Override
//    public Browser get(BrowserType type) {
//        log.info("Get browser with type {} started", type.getName());
//        Browser result = get();
//        result.setType(type);
//        log.info("Get browser with type {} completed", type.getName());
//        return result;
//    }
//
//    @Override
//    public Browser get(BrowserType type, boolean maximize) {
//        log.info("Get browser with type {} and maximize {} started", type.getName(), maximize);
//        Browser result = get(type);
//        result.setMaximize(maximize);
//        log.info("Get browser with type {} and maximize {} completed", type.getName(), maximize);
//        return result;
//    }
//
//    @Override
//    public Browser get(BrowserType type, boolean maximize, boolean headless) {
//        log.info("Get browser with type {}, maximize {}, and headless {} started", type.getName(), maximize, headless);
//        Browser result = get(type, maximize);
//        result.setHeadless(headless);
//        log.info("Get browser with type {}, maximize {}, and headless {} completed", type.getName(), maximize, headless);
//        return result;
//    }
//
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