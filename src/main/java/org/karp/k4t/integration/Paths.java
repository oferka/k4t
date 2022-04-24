package org.karp.k4t.integration;

import static org.karp.k4t.integration.ServiceNames.SEARCH_TERM_SERVICE_NAME;
import static org.karp.k4t.integration.ServiceNames.USER_SERVICE_NAME;

public interface Paths {

    String BASE_PATH = "api/rest/";

    String COUNT_PATH = "/count";

    String RANDOM_PATH = "/random";

    String RANDOM_ID_PATH = RANDOM_PATH + "/id";

    String SEARCH_TERM_PATH = BASE_PATH + SEARCH_TERM_SERVICE_NAME;

    String USER_PATH = BASE_PATH + USER_SERVICE_NAME;
}