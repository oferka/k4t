package org.karp.k4t.ui;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.karp.k4t.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
public abstract class ViewTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    public void startApplication() {
        log.info("Start application started");
        applicationContext = SpringApplication.run(Application.class);
        log.info("Start application completed. Application ID is: {}", applicationContext.getId());
    }

    @AfterEach
    public void stopApplication() {
        log.info("Stop application started");
        int exitCode = SpringApplication.exit(applicationContext);
        log.info("Stop application completed. Exit code is: {}", exitCode);
    }
}
