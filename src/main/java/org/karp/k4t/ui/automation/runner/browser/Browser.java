package org.karp.k4t.ui.automation.runner.browser;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Browser {

    @Getter
    @Setter
    @NotNull
    private BrowserType type;

    @Getter
    @Setter
    private boolean maximize;

    @Getter
    @Setter
    private boolean headless;

    @AllArgsConstructor
    @ToString
    public enum BrowserType {

        CHROME("chrome"),
        FIREFOX("firefox");

        @Getter
        @NotNull
        @Size(min = 2, max = 16)
        @NotBlank
        private final String name;
    }
}
