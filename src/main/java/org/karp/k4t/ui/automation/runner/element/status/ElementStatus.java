package org.karp.k4t.ui.automation.runner.element.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@ToString
public enum ElementStatus {

    READY("Ready"),
    IN_PROGRESS("In Progress"),
    PASSED("Passed"),
    FAILED("Failed"),
    TIMED_OUT("Timed Out"),
    NO_CONTENT("No Content");

    @Getter
    @NotNull
    @Size(min = 2, max = 32)
    @NotBlank
    private final String name;
}