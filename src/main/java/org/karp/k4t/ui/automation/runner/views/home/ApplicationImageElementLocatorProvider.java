package org.karp.k4t.ui.automation.runner.views.home;

import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.shared.ApplicationImage.CLASS_NAME;

@Service
public class ApplicationImageElementLocatorProvider {

    public @NotNull By getControlsContainer() {
        return By.className(CLASS_NAME);
    }
}
