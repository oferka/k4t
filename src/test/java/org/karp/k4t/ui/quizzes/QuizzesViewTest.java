package org.karp.k4t.ui.quizzes;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.karp.k4t.ui.ViewTest;
import org.karp.k4t.ui.automation.runner.destination.DestinationProvider;
import org.karp.k4t.ui.automation.runner.views.quizzes.QuizzesViewRetriever;
import org.karp.k4t.ui.automation.runner.views.quizzes.QuizzesViewStatusMarker;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

import static org.karp.k4t.ui.automation.runner.element.status.ElementStatus.*;

@Slf4j
public class QuizzesViewTest extends ViewTest {

    @Autowired
    private DestinationProvider destinationProvider;

    @Autowired
    private QuizzesViewRetriever quizzesViewRetriever;

    @Autowired
    private QuizzesViewStatusMarker quizzesViewStatusMarker;

    @BeforeEach
    public void loadView() {
        log.info("Load quizzes view started");
        URI viewUri = destinationProvider.getQuizzesView();
        driver.get(viewUri.toString());
        quizzesViewRetriever.get(driver, 30);
        log.info("Load quizzes view completed");
    }

    @Test
    public void shouldDisplayInitialContent() {
        quizzesViewStatusMarker.mark(driver, READY);
        quizzesViewStatusMarker.mark(driver, IN_PROGRESS);
        quizzesViewStatusMarker.mark(driver, PASSED);
        quizzesViewStatusMarker.mark(driver, FAILED);
        quizzesViewStatusMarker.mark(driver, TIMED_OUT);
        quizzesViewStatusMarker.mark(driver, NO_CONTENT);
    }
}
