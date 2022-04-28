package org.karp.k4t.ui.automation.runner.info.screenshot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class ScreenshotTaker {

    @NotNull
    private final ScreenshotTakerConfiguration screenshotTakerConfiguration;

    public void take(@NotNull String flowName, @NotNull String executionId, @Valid @NotNull WebDriver driver) {
        take(flowName, executionId, driver, true);
    }

    public void take(@NotNull String flowName, @NotNull String executionId, @Valid @NotNull WebDriver driver, boolean condition) {
        if(condition) {
            log.info("Take screenshot started");
            if (screenshotTakerConfiguration.isEnabled()) {
                Screenshot screenshot = new AShot().takeScreenshot(driver);
                File destinationFile = getDestinationFile(flowName, executionId);
                try {
                    ImageIO.write(screenshot.getImage(), "png", destinationFile);
                }
                catch (IOException e) {
                    log.error("Failed to take screenshot", e);
                }
            }
            else {
                log.info("Screenshot execution is not enabled");
            }
            log.info("Take screenshot completed");
        }
    }

    private File getDestinationFile(@NotNull String flowName, @NotNull String executionId) {
        log.info("Get destination file started");
        File directory = new File(format("./target/screenshots/%s/%s", flowName, executionId));
        if(!directory.exists()) {
            boolean directoryCreated = directory.mkdirs();
            if(directoryCreated) {
                log.info("Directory with path '{}' was successfully created", directory.getPath());
            }
            else {
                log.error("Failed to create directory with path '{}'", directory.getPath());
            }
        }
        String fileName = format("%s.png", currentTimeMillis());
        File result = new File(directory, fileName);
        log.info("Get destination file completed. Result file path is: '{}'", result.getPath());
        return result;
    }
}
