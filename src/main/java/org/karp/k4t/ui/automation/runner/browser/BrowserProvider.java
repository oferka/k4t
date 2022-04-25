package org.karp.k4t.ui.automation.runner.browser;

import javax.validation.constraints.NotNull;

public interface BrowserProvider {

    @NotNull Browser get();

    @NotNull Browser get(BrowserProviderConfiguration configuration);

//    @NotNull Browser get(BrowserType type);
//
//    @NotNull Browser get(BrowserType type, boolean maximize);
//
//    @NotNull Browser get(BrowserType type, boolean maximize, boolean headless);
}