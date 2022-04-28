package org.karp.k4t.ui.automation.runner.destination;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class DefaultDestinationProvider implements DestinationProvider {

    private final UriComponentsProvider uriComponentsProvider;

    @Override
    public URI getDefaultView() {
        return null;
    }

    @Override
    public URI getFeedView() {
        return null;
    }
}
