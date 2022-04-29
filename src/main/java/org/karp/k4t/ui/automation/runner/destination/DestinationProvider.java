package org.karp.k4t.ui.automation.runner.destination;

import javax.validation.constraints.NotNull;
import java.net.URI;

public interface DestinationProvider {

    @NotNull URI getDefaultView();

    @NotNull URI getFeedView();

    @NotNull URI getHomeView();
}
