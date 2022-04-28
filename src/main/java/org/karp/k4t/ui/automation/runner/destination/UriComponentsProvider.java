package org.karp.k4t.ui.automation.runner.destination;

import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface UriComponentsProvider {

    @NotNull
    UriComponents get(int port, @Valid @NotNull String path);

    @NotNull
    UriComponents get(@Valid @NotNull String path);

    @NotNull
    UriComponents get();
}