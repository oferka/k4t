package org.karp.k4t.controller;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.service.SearchTermService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.karp.k4t.integration.Paths.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = SEARCH_TERM_PATH)
public class SearchTermController {

    private final SearchTermService searchTermService;

    @GetMapping
    @Timed(value = "SearchTermController.findAll.timer", description = "Timer for search term findAll endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.findAll.counter", description = "Counter for search term findAll endpoint")
    @Operation(summary = "Find all search terms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search terms successfully found", content = { @Content(mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = SearchTerm.class)))}),
            @ApiResponse(responseCode = "400", description = "Failed to find search terms", content = @Content) }
    )
    public @NotNull ResponseEntity<List<SearchTerm>> findAll() {
        List<SearchTerm> items = searchTermService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping(value = "{id}")
    @Timed(value = "SearchTermController.findById.timer", description = "Timer for search term findById endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.findById.counter", description = "Counter for search term findById endpoint")
    @Operation(summary = "Find a search term by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search term successfully found by id", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = SearchTerm.class))}),
            @ApiResponse(responseCode = "404", description = "Search term with specified id was not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to find search term by id", content = @Content) })
    public @NotNull ResponseEntity<SearchTerm> findById(@Parameter(description = "The id of the search term to be found") @PathVariable("id") @NotNull Long id) {
        Optional<SearchTerm> item = searchTermService.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = RANDOM_PATH)
    @Timed(value = "SearchTermController.findRandom.timer", description = "Timer for search term findRandom endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.findRandom.counter", description = "Counter for search term findRandom endpoint")
    @Operation(summary = "Find a random search term")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Random search term successfully found", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = SearchTerm.class))}),
            @ApiResponse(responseCode = "404", description = "Random search term was not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to find a random search term", content = @Content) })
    public @NotNull ResponseEntity<SearchTerm> findRandom() {
        Optional<SearchTerm> item = searchTermService.findRandom();
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = RANDOM_ID_PATH)
    @Timed(value = "SearchTermController.findRandomId.timer", description = "Timer for search term findRandomId endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.findRandomId.counter", description = "Counter for search term findRandomId endpoint")
    @Operation(summary = "Find a random search term ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Random search term ID successfully found", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Long.class))}),
            @ApiResponse(responseCode = "404", description = "Random search term ID was not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to find a random search term ID", content = @Content) })
    public @NotNull ResponseEntity<Long> findRandomId() {
        Optional<Long> item = searchTermService.findRandomId();
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Timed(value = "SearchTermController.save.timer", description = "Timer for search term save endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.save.counter", description = "Counter for search term save endpoint")
    @Operation(summary = "Create an search term")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Search term created successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = SearchTerm.class))}),
            @ApiResponse(responseCode = "400", description = "Failed to create an search term", content = @Content) })
    public @NotNull ResponseEntity<SearchTerm> save(@Parameter(description = "Search term to be saved") @RequestBody @Valid @NotNull SearchTerm searchTerm) {
        HttpHeaders httpHeaders = new HttpHeaders();
        URI location = linkTo(SearchTermController.class).slash(searchTerm.getId()).toUri();
        httpHeaders.setLocation(location);
        SearchTerm saved = searchTermService.save(searchTerm);
        return new ResponseEntity<>(saved, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping()
    @Timed(value = "SearchTermController.delete.timer", description = "Timer for search term delete endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.delete.counter", description = "Counter for search term delete endpoint")
    @Operation(summary = "Delete a search term")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Search term successfully deleted"),
            @ApiResponse(responseCode = "400", description = "Failed to delete search term", content = @Content) })
    public @NotNull ResponseEntity<SearchTerm> delete(@Parameter(description = "Search term to be deleted") @RequestBody @NotNull @Valid SearchTerm searchTerm) {
        Optional<SearchTerm> deleted = searchTermService.delete(searchTerm);
        return deleted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Timed(value = "SearchTermController.deleteById.timer", description = "Timer for search term deleteById endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.deleteById.counter", description = "Counter for search term deleteById endpoint")
    @Operation(summary = "Delete an search term by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Search term successfully deleted by id"),
            @ApiResponse(responseCode = "400", description = "Failed to delete search term by id", content = @Content) })
    public @NotNull ResponseEntity<SearchTerm> deleteById(@Parameter(description = "The id of the search term to be deleted") @PathVariable("id") @NotNull Long id) {
        Optional<SearchTerm> deleted = searchTermService.deleteById(id);
        return deleted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    @Timed(value = "SearchTermController.update.timer", description = "Timer for search term update endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.update.counter", description = "Counter for search term update endpoint")
    @Operation(summary = "Update an search term")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search term updated successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = SearchTerm.class))}),
            @ApiResponse(responseCode = "404", description = "Search term not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to update search term", content = @Content) })
    public @NotNull ResponseEntity<SearchTerm> update(@Parameter(description = "Search term to be updated") @RequestBody @NotNull @Valid SearchTerm searchTerm) {
        Optional<SearchTerm> updated = searchTermService.update(searchTerm);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = COUNT_PATH)
    @Timed(value = "SearchTermController.count.timer", description = "Timer for search term count endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "SearchTermController.count.counter", description = "Counter for search term count endpoint")
    @Operation(summary = "Return the number of existing search terms")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search term counted successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Long.class))}),
            @ApiResponse(responseCode = "400", description = "Failed to count search terms", content = @Content) })
    public @NotNull ResponseEntity<Long> count() {
        long count = searchTermService.count();
        return ResponseEntity.ok(count);
    }
}
