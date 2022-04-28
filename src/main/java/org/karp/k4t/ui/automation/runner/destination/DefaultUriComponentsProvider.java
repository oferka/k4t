package org.karp.k4t.ui.automation.runner.destination;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class DefaultUriComponentsProvider implements UriComponentsProvider {

    @NotNull
    private final UriComponentsProviderConfiguration uriComponentsProviderConfiguration;

    @Override
    public @NotNull
    UriComponents get(int port, @Valid @NotNull String path) {
        log.info("Get Uri components started");
        UriComponents result = UriComponentsBuilder
                .newInstance()
                .scheme(uriComponentsProviderConfiguration.getSchema())
                .host(uriComponentsProviderConfiguration.getHost())
                .port(port)
                .path(path)
                .build();
        log.info("Get Uri components completed. Result is {}", result);
        return result;
    }

    @Override
    public @NotNull UriComponents get(@Valid @NotNull String path) {
        return get(uriComponentsProviderConfiguration.getPort(), path);
    }

    @Override
    public @NotNull UriComponents get() {
        return get(EMPTY);
    }
}