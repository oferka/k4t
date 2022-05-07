package org.karp.k4t.ui.automation.runner.element.attribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.karp.k4t.ui.automation.runner.element.status.ElementStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@ToString
public enum ElementAttribute {

    BORDER_STYLE("border-style") {
        @Override
        public String getValue(ElementStatus elementStatus) {
            String result = null;
            switch (elementStatus) {
                case READY:
                case PASSED:
                    result = "solid";
                    break;
                case IN_PROGRESS:
                    result = "dotted";
                    break;
                case FAILED:
                case TIMED_OUT:
                case NO_CONTENT:
                    result = "double";
                    break;
            }
            return result;
        }
    },
    BORDER_WIDTH("border-width") {
        @Override
        public String getValue(ElementStatus elementStatus) {
            String result = null;
            switch (elementStatus) {
                case READY:
                case IN_PROGRESS:
                case PASSED:
                    result = "medium";
                    break;
                case FAILED:
                case TIMED_OUT:
                case NO_CONTENT:
                    result = "thick";
                    break;
            }
            return result;
        }
    },
    BORDER_COLOR("border-color") {
        @Override
        public String getValue(ElementStatus elementStatus) {
            String result = null;
            switch (elementStatus) {
                case READY:
                    result = "#073b4c";
                    break;
                case IN_PROGRESS:
                    result = "#118ab2";
                    break;
                case PASSED:
                    result = "#06d6a0";
                    break;
                case FAILED:
                    result = "#ef476f";
                    break;
                case TIMED_OUT:
                    result = "#ffd166";
                    break;
                case NO_CONTENT:
                    result = "#f07167";
                    break;
            }
            return result;
        }
    };

    @Getter
    @NotNull
    @Size(min = 2, max = 32)
    @NotBlank
    private final String name;

    public abstract @NotNull String getValue(ElementStatus elementStatus);
}
