package org.karp.k4t.ui.automation.runner.destination;

import org.junit.jupiter.api.Test;
import org.karp.k4t.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponents;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
class UriComponentsProviderTest {

    @Autowired
    private UriComponentsProvider uriComponentsProvider;

    @Test
    public void shouldGetDefault() {
        UriComponents uriComponents = uriComponentsProvider.get();
        assertNotNull(uriComponents);
    }

    @Test
    public void shouldGetWithSpecifiedPath() {
        String path = "path";
        UriComponents uriComponents = uriComponentsProvider.get(path);
        assertNotNull(uriComponents);
        assertEquals(path, uriComponents.getPath());
    }

    @Test
    public void shouldGetWithSpecifiedPortAndPath() {
        int port = 8888;
        String path = "path";
        UriComponents uriComponents = uriComponentsProvider.get(port, path);
        assertNotNull(uriComponents);
        assertEquals(port, uriComponents.getPort());
        assertEquals(path, uriComponents.getPath());
    }
}