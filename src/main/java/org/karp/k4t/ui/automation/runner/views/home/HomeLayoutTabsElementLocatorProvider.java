package org.karp.k4t.ui.automation.runner.views.home;

import org.karp.k4t.ui.home.HomeLayoutTab;
import org.karp.k4t.ui.home.HomeView;
import org.karp.k4t.ui.questions.QuestionsView;
import org.karp.k4t.ui.quizzes.QuizzesView;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

import static java.lang.String.format;
import static org.karp.k4t.ui.home.HomeLayoutTabs.CLASS_NAME;

@Service
public class HomeLayoutTabsElementLocatorProvider {

    public @NotNull By getBackgroundContainer() {
        return By.className(CLASS_NAME);
    }

    public @NotNull By getHomeTab() {
        return By.id(format("%s-%s", HomeLayoutTab.CLASS_NAME, HomeView.NAME));
    }

    public @NotNull By getQuestionsTab() {
        return By.id(format("%s-%s", HomeLayoutTab.CLASS_NAME, QuestionsView.NAME));
    }

    public @NotNull By getQuizzesTab() {
        return By.id(format("%s-%s", HomeLayoutTab.CLASS_NAME, QuizzesView.NAME));
    }
}
