package org.karp.k4t.ui.automation.runner.views.questions;

import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.questions.QuestionsView.CLASS_NAME;

@Service
public class QuestionsViewElementLocatorProvider {

    public @NotNull By getBackgroundContainer() {
        return By.className(CLASS_NAME);
    }

    public @NotNull By getControlsContainer() {
        return By.className(CLASS_NAME.concat("-text"));
    }
}
