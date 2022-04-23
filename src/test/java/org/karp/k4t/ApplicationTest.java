package org.karp.k4t;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ApplicationTest {

    @Test
    void shouldLoadApplication() {
        log.info("Application loaded successfully");
    }
}