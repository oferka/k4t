package org.karp.k4t.ui.automation.runner.actions.pause;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Duration;

@Service
@Slf4j
@Validated
@RequiredArgsConstructor
public class ExecutionPauser {

    @NotNull
    private final ExecutionPauserConfiguration executionPauserConfiguration;

    public void pause() {
        pause(Duration.ofMillis(executionPauserConfiguration.getDefaultDelayInMillis()));
    }

    public void pause(@Valid @NotNull Duration duration) {
        if(executionPauserConfiguration.isEnabled()) {
            long delayInMillis = duration.toMillis();
            log.debug("Pause execution for '{}' milliseconds started", delayInMillis);
            try {
                Thread.sleep(delayInMillis);
            }
            catch (InterruptedException e) {
                log.error("Failed to pause execution. error message is '{}'", e.getMessage());
            }
            log.debug("Pause execution for '{}' milliseconds completed", delayInMillis);
        }
    }
}