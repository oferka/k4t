package org.karp.k4t.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.karp.k4t.model.User;
import org.karp.k4t.model.UserTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.karp.k4t.TestDataUtils.getNonExistingId;
import static org.karp.k4t.integration.Paths.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class UserControllerTest extends UserTest {

    private MockMvc mvc;

    @BeforeEach
    public void setup(WebApplicationContext webApplicationContext) {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldFindAll() throws Exception {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        MvcResult mvcResult = mvc.perform(get(format("/%s", USER_PATH))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(items.get(0).getId().toString())))
                .andReturn();
        assertNotNull(mvcResult);
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldFindById() throws Exception {
        List<User> items = userContentProvider.get(getNumberOfItemsToLoad());
        Iterable<User> saved = userRepository.saveAll(items);
        Long id = items.get(0).getId();
        MvcResult mvcResult = mvc.perform(get(format("/%s/{id}", USER_PATH), id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(id.toString())))
                .andReturn();
        assertNotNull(mvcResult);
        userRepository.deleteAll(saved);
    }

    @Test
    public void shouldNotFindById() throws Exception {
        MvcResult mvcResult = mvc.perform(get(format("/%s/{id}", USER_PATH), getNonExistingId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isNotFound())
                .andReturn();
        assertNotNull(mvcResult);
    }

    @Test
    public void shouldFindRandom() throws Exception {
        MvcResult mvcResult = mvc.perform(get(format("/%s/%s", USER_PATH, RANDOM_PATH))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andReturn();
        assertNotNull(mvcResult);
        Integer id = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.id");
        assertNotNull(id);
    }

    @Test
    public void shouldFindRandomId() throws Exception {
        MvcResult mvcResult = mvc.perform(get(format("/%s/%s", USER_PATH, RANDOM_ID_PATH))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(log())
                .andExpect(status().isOk())
                .andReturn();
        assertNotNull(mvcResult);
    }

//    @Test
//    public void shouldSave() throws Exception {
//        SearchTerm item = searchTermContentProvider.get();
//        MvcResult mvcResult = mvc.perform(post(format("/%s", SEARCH_TERM_PATH))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(item))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(log())
//                .andExpect(status().isCreated())
//                .andReturn();
//        assertNotNull(mvcResult);
//        Integer id = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.id");
//        assertNotNull(id);
//        searchTermRepository.deleteById(id.longValue());
//    }
//
//    @Test
//    public void shouldDelete() throws Exception {
//        SearchTerm item = searchTermContentProvider.get();
//        SearchTerm saved = searchTermRepository.save(item);
//        MvcResult mvcResult = mvc.perform(delete(format("/%s", SEARCH_TERM_PATH))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(saved))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(log())
//                .andExpect(status().isOk())
//                .andReturn();
//        assertNotNull(mvcResult);
//        Integer id = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.id");
//        assertNotNull(id);
//    }
//
//    @Test
//    public void shouldNotDelete() throws Exception {
//        SearchTerm item = searchTermContentProvider.get();
//        SearchTerm toBeDeleted = createSearchTermWithNonExistingId(item);
//        MvcResult mvcResult = mvc.perform(delete(format("/%s", SEARCH_TERM_PATH))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(toBeDeleted))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(log())
//                .andExpect(status().isNotFound())
//                .andReturn();
//        assertNotNull(mvcResult);
//    }
//
//    @Test
//    public void shouldDeleteById() throws Exception {
//        SearchTerm item = searchTermContentProvider.get();
//        SearchTerm saved = searchTermRepository.save(item);
//        Long id = saved.getId();
//        MvcResult mvcResult = mvc.perform(delete(format("/%s/{id}", SEARCH_TERM_PATH), id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(log())
//                .andExpect(status().isOk())
//                .andReturn();
//        assertNotNull(mvcResult);
//        boolean exists = searchTermRepository.existsById(id);
//        assertFalse(exists);
//    }
//
//    @Test
//    public void shouldNotDeleteById() throws Exception {
//        MvcResult mvcResult = mvc.perform(delete(format("/%s/{id}", SEARCH_TERM_PATH), getNonExistingId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(log())
//                .andExpect(status().isNotFound())
//                .andReturn();
//        assertNotNull(mvcResult);
//    }
//
//    @Test
//    public void shouldUpdate() throws Exception {
//        SearchTerm item = searchTermContentProvider.get();
//        SearchTerm saved = searchTermRepository.save(item);
//        Long id = saved.getId();
//        MvcResult mvcResult = mvc.perform(put(format("/%s", SEARCH_TERM_PATH))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(item))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(log())
//                .andExpect(status().isOk())
//                .andReturn();
//        assertNotNull(mvcResult);
//        Optional<SearchTerm> updated = searchTermRepository.findById(id);
//        assertTrue(updated.isPresent());
//        searchTermRepository.deleteById(id);
//    }
//
//    @Test
//    public void shouldNotUpdate() throws Exception {
//        SearchTerm item = searchTermContentProvider.get();
//        SearchTerm toBeUpdated = createSearchTermWithNonExistingId(item);
//        MvcResult mvcResult = mvc.perform(put(format("/%s", SEARCH_TERM_PATH))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(toBeUpdated))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(log())
//                .andExpect(status().isNotFound())
//                .andReturn();
//        assertNotNull(mvcResult);
//    }
//
//    @Test
//    public void shouldCount() throws Exception {
//        List<SearchTerm> items = searchTermContentProvider.get(getNumberOfItemsToLoad());
//        Iterable<SearchTerm> saved = searchTermRepository.saveAll(items);
//        MvcResult mvcResult = mvc.perform(get(format("/%s/%s", SEARCH_TERM_PATH, COUNT_PATH))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(log())
//                .andExpect(status().isOk())
//                .andReturn();
//        assertNotNull(mvcResult);
//        searchTermRepository.deleteAll(saved);
//    }
}