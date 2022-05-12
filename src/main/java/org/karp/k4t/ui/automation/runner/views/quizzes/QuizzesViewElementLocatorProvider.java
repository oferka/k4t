package org.karp.k4t.ui.automation.runner.views.quizzes;

import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.quizzes.QuizzesView.CLASS_NAME;

@Service
public class QuizzesViewElementLocatorProvider {

    public @NotNull By getBackgroundContainer() {
        return By.className(CLASS_NAME);
    }

    public @NotNull By getControlsContainer() {
        return By.className(CLASS_NAME.concat("-text"));
    }
}
