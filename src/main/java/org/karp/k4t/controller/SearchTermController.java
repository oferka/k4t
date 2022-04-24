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

//    @PostMapping
//    @Timed(value = "AccountController.save.timer", description = "Timer for account save endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "AccountController.save.counter", description = "Counter for account save endpoint")
//    @Operation(summary = "Create an account")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Account created successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Account.class))}),
//            @ApiResponse(responseCode = "400", description = "Failed to create an account", content = @Content) })
//    public @NotNull ResponseEntity<Account> save(@Parameter(description = "Account to be saved") @RequestBody @Valid @NotNull Account account) {
//        HttpHeaders httpHeaders = new HttpHeaders();
//        URI location = linkTo(AccountController.class).slash(account.getId()).toUri();
//        httpHeaders.setLocation(location);
//        Account saved = accountService.save(account);
//        return new ResponseEntity<>(saved, httpHeaders, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping()
//    @Timed(value = "AccountController.delete.timer", description = "Timer for account delete endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "AccountController.delete.counter", description = "Counter for account delete endpoint")
//    @Operation(summary = "Delete an account")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Account successfully deleted"),
//            @ApiResponse(responseCode = "400", description = "Failed to delete account", content = @Content) })
//    public @NotNull ResponseEntity<Account> delete(@Parameter(description = "Account to be deleted") @RequestBody @NotNull @Valid Account account) {
//        Optional<Account> deleted = accountService.delete(account);
//        return deleted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    @Timed(value = "AccountController.deleteById.timer", description = "Timer for account deleteById endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "AccountController.deleteById.counter", description = "Counter for account deleteById endpoint")
//    @Operation(summary = "Delete an account by id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Account successfully deleted by id"),
//            @ApiResponse(responseCode = "400", description = "Failed to delete account by id", content = @Content) })
//    public @NotNull ResponseEntity<Account> deleteById(@Parameter(description = "The id of the account to be deleted") @PathVariable("id") @NotNull Long id) {
//        Optional<Account> deleted = accountService.deleteById(id);
//        return deleted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping
//    @Timed(value = "AccountController.update.timer", description = "Timer for account update endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "AccountController.update.counter", description = "Counter for account update endpoint")
//    @Operation(summary = "Update an account")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Account updated successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Account.class))}),
//            @ApiResponse(responseCode = "404", description = "Account not found", content = @Content),
//            @ApiResponse(responseCode = "400", description = "Failed to update account", content = @Content) })
//    public @NotNull ResponseEntity<Account> update(@Parameter(description = "Account to be updated") @RequestBody @NotNull @Valid Account account) {
//        Optional<Account> updated = accountService.update(account);
//        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping(path = COUNT_PATH)
//    @Timed(value = "AccountController.count.timer", description = "Timer for account count endpoint", percentiles = { 0.01, 0.05,0.50, 0.95, 0.99})
//    @Counted(value = "AccountController.count.counter", description = "Counter for account count endpoint")
//    @Operation(summary = "Return the number of existing accounts")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Accounts counted successfully", content = { @Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = Long.class))}),
//            @ApiResponse(responseCode = "400", description = "Failed to count accounts", content = @Content) })
//    public @NotNull ResponseEntity<Long> count() {
//        long count = accountService.count();
//        return ResponseEntity.ok(count);
//    }
}
