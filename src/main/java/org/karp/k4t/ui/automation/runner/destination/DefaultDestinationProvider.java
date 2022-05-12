package org.karp.k4t.ui.automation.runner.destination;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.feed.FeedView;
import org.karp.k4t.ui.home.HomeView;
import org.karp.k4t.ui.questions.QuestionsView;
import org.karp.k4t.ui.quizzes.QuizzesView;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponents;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
@Validated
public class DefaultDestinationProvider implements DestinationProvider {

    private final UriComponentsProvider uriComponentsProvider;

    @Override
    public URI getDefaultView() {
        log.info("Get URI for default view started");
        UriComponents uriComponents = uriComponentsProvider.get();
        URI result = uriComponents.toUri();
        log.info("Get URI for default view completed. Result is {}", result);
        return result;
    }

    @Override
    public URI getFeedView() {
        log.info("Get URI for feed view started");
        UriComponents uriComponents = uriComponentsProvider.get(FeedView.ROUTE);
        URI result = uriComponents.toUri();
        log.info("Get URI for feed view completed. Result is {}", result);
        return result;
    }

    @Override
    public URI getHomeView() {
        log.info("Get URI for feed home started");
        UriComponents uriComponents = uriComponentsProvider.get(HomeView.ROUTE);
        URI result = uriComponents.toUri();
        log.info("Get URI for home view completed. Result is {}", result);
        return result;
    }

    @Override
    public URI getQuestionsView() {
        log.info("Get URI for feed questions started");
        UriComponents uriComponents = uriComponentsProvider.get(QuestionsView.ROUTE);
        URI result = uriComponents.toUri();
        log.info("Get URI for questions view completed. Result is {}", result);
        return result;
    }

    @Override
    public URI getQuizzesView() {
        log.info("Get URI for feed quizzes started");
        UriComponents uriComponents = uriComponentsProvider.get(QuizzesView.ROUTE);
        URI result = uriComponents.toUri();
        log.info("Get URI for quizzes view completed. Result is {}", result);
        return result;
    }
}
