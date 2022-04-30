package org.karp.k4t.ui.automation.runner.views.home;

import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.home.HomeLayout.ID;

@Service
public class HomeLayoutElementLocatorProvider {

    public @NotNull By getBackgroundContainer() {
        return By.id(ID);
    }
}
