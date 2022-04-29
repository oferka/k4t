package org.karp.k4t.ui.automation.runner.views.home;

import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.home.HomeView.ID;

@Service
public class HomeViewElementLocatorProvider {

    public @NotNull By getBackgroundContainer() {
        return By.className(ID);
    }

    public @NotNull By getControlsContainer() {
        return By.className(ID.concat("-text"));
    }
}
