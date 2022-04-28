package org.karp.k4t.ui.automation.runner.views.feed;

import org.karp.k4t.ui.feed.FeedView;
import org.openqa.selenium.By;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class FeedViewElementLocatorProvider {

    public @NotNull By getBackgroundContainer() {
        return By.className(FeedView.ID);
    }

    public @NotNull By getControlsContainer() {
        return By.className(FeedView.ID.concat("-text"));
    }
}
