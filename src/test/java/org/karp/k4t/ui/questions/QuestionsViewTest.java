package org.karp.k4t.ui.questions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.karp.k4t.ui.ViewTest;
import org.karp.k4t.ui.automation.runner.destination.DestinationProvider;
import org.karp.k4t.ui.automation.runner.views.questions.QuestionsViewRetriever;
import org.karp.k4t.ui.automation.runner.views.questions.QuestionsViewStatusMarker;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

import static org.karp.k4t.ui.automation.runner.element.status.ElementStatus.*;

@Slf4j
public class QuestionsViewTest extends ViewTest {

    @Autowired
    private DestinationProvider destinationProvider;

    @Autowired
    private QuestionsViewRetriever questionsViewRetriever;

    @Autowired
    private QuestionsViewStatusMarker questionsViewStatusMarker;

    @BeforeEach
    public void loadView() {
        log.info("Load questions view started");
        URI viewUri = destinationProvider.getQuestionsView();
        driver.get(viewUri.toString());
        questionsViewRetriever.get(driver, 30);
        log.info("Load questions view completed");
    }

    @Test
    public void shouldDisplayInitialContent() {
        questionsViewStatusMarker.mark(driver, READY);
        questionsViewStatusMarker.mark(driver, IN_PROGRESS);
        questionsViewStatusMarker.mark(driver, PASSED);
        questionsViewStatusMarker.mark(driver, FAILED);
        questionsViewStatusMarker.mark(driver, TIMED_OUT);
        questionsViewStatusMarker.mark(driver, NO_CONTENT);
    }
}
