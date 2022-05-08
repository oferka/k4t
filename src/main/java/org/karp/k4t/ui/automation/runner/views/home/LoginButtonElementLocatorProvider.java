package org.karp.k4t.ui.automation.runner.views.home;

import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.shared.LoginButton.CLASS_NAME;

@Service
public class LoginButtonElementLocatorProvider {

    public @NotNull By getBackgroundContainer() {
        return By.className(CLASS_NAME);
    }
}
