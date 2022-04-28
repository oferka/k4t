package org.karp.k4t.ui.automation.runner.browser;

import javax.validation.constraints.NotNull;

public interface BrowserProvider {

    @NotNull Browser get();

    @NotNull Browser get(BrowserProviderConfiguration configuration);
}