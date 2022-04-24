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
import org.karp.k4t.model.User;
import org.karp.k4t.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import static org.karp.k4t.integration.Paths.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = USER_PATH)
public class UserController {

    private final UserService userService;

    @GetMapping
    @Timed(value = "UserController.findAll.timer", description = "Timer for user findAll endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "UserController.findAll.counter", description = "Counter for user findAll endpoint")
    @Operation(summary = "Find all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users successfully found", content = { @Content(mediaType = APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = User.class)))}),
            @ApiResponse(responseCode = "400", description = "Failed to find users", content = @Content) }
    )
    public @NotNull ResponseEntity<List<User>> findAll() {
        List<User> items = userService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping(value = "{id}")
    @Timed(value = "UserController.findById.timer", description = "Timer for user findById endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "UserController.findById.counter", description = "Counter for user findById endpoint")
    @Operation(summary = "Find a user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully found by id", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "User with specified id was not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to find user by id", content = @Content) })
    public @NotNull ResponseEntity<User> findById(@Parameter(description = "The id of the user to be found") @PathVariable("id") @NotNull Long id) {
        Optional<User> item = userService.findById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = RANDOM_PATH)
    @Timed(value = "UserController.findRandom.timer", description = "Timer for user findRandom endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "UserController.findRandom.counter", description = "Counter for user findRandom endpoint")
    @Operation(summary = "Find a random user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Random user successfully found", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "404", description = "Random user was not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to find a random user", content = @Content) })
    public @NotNull ResponseEntity<User> findRandom() {
        Optional<User> item = userService.findRandom();
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = RANDOM_ID_PATH)
    @Timed(value = "UserController.findRandomId.timer", description = "Timer for user findRandomId endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
    @Counted(value = "UserController.findRandomId.counter", description = "Counter for user findRandomId endpoint")
    @Operation(summary = "Find a random user ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Random user ID successfully found", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Long.class))}),
            @ApiResponse(responseCode = "404", description = "Random user ID was not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Failed to find a random user ID", content = @Content) })
    public @NotNull ResponseEntity<Long> findRandomId() {
        Optional<Long> item = userService.findRandomId();
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping
//    @Timed(value = "SearchTermController.save.timer", description = "Timer for search term save endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "SearchTermController.save.counter", description = "Counter for search term save endpoint")
//    @Operation(summary = "Create an search term")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Search term created successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = SearchTerm.class))}),
//            @ApiResponse(responseCode = "400", description = "Failed to create an search term", content = @Content) })
//    public @NotNull ResponseEntity<SearchTerm> save(@Parameter(description = "Search term to be saved") @RequestBody @Valid @NotNull SearchTerm searchTerm) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        URI location = linkTo(SearchTermController.class).slash(searchTerm.getId()).toUri();
//        httpHeaders.setLocation(location);
//        SearchTerm saved = searchTermService.save(searchTerm);
//        return new ResponseEntity<>(saved, httpHeaders, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping()
//    @Timed(value = "SearchTermController.delete.timer", description = "Timer for search term delete endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "SearchTermController.delete.counter", description = "Counter for search term delete endpoint")
//    @Operation(summary = "Delete a search term")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Search term successfully deleted"),
//            @ApiResponse(responseCode = "400", description = "Failed to delete search term", content = @Content) })
//    public @NotNull ResponseEntity<SearchTerm> delete(@Parameter(description = "Search term to be deleted") @RequestBody @NotNull @Valid SearchTerm searchTerm) {
//        Optional<SearchTerm> deleted = searchTermService.delete(searchTerm);
//        return deleted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    @Timed(value = "SearchTermController.deleteById.timer", description = "Timer for search term deleteById endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "SearchTermController.deleteById.counter", description = "Counter for search term deleteById endpoint")
//    @Operation(summary = "Delete an search term by id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Search term successfully deleted by id"),
//            @ApiResponse(responseCode = "400", description = "Failed to delete search term by id", content = @Content) })
//    public @NotNull ResponseEntity<SearchTerm> deleteById(@Parameter(description = "The id of the search term to be deleted") @PathVariable("id") @NotNull Long id) {
//        Optional<SearchTerm> deleted = searchTermService.deleteById(id);
//        return deleted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping
//    @Timed(value = "SearchTermController.update.timer", description = "Timer for search term update endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "SearchTermController.update.counter", description = "Counter for search term update endpoint")
//    @Operation(summary = "Update an search term")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Search term updated successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = SearchTerm.class))}),
//            @ApiResponse(responseCode = "404", description = "Search term not found", content = @Content),
//            @ApiResponse(responseCode = "400", description = "Failed to update search term", content = @Content) })
//    public @NotNull ResponseEntity<SearchTerm> update(@Parameter(description = "Search term to be updated") @RequestBody @NotNull @Valid SearchTerm searchTerm) {
//        Optional<SearchTerm> updated = searchTermService.update(searchTerm);
//        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping(path = COUNT_PATH)
//    @Timed(value = "SearchTermController.count.timer", description = "Timer for search term count endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "SearchTermController.count.counter", description = "Counter for search term count endpoint")
//    @Operation(summary = "Return the number of existing search terms")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Search term counted successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Long.class))}),
//            @ApiResponse(responseCode = "400", description = "Failed to count search terms", content = @Content) })
//    public @NotNull ResponseEntity<Long> count() {
//        long count = searchTermService.count();
//        return ResponseEntity.ok(count);
//    }
}
