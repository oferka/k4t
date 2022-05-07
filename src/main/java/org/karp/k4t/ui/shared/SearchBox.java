package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.QueryParameters;
import elemental.json.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.SearchView;
import org.karp.k4t.ui.search.terms.SearchState;
import org.karp.k4t.ui.search.terms.SearchTermChangeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.karp.k4t.ui.SearchView.QUERY_PARAM_NAME;
import static org.karp.k4t.ui.SearchView.TYPE_PARAM_NAME;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@Slf4j
@CssImport(SHARED_FOLDER + SearchBox.CLASS_NAME + CSS_FILE_EXTENSION)
public class SearchBox extends ComboBox<SearchTerm> {

    public static final String CLASS_NAME = "search-box";

    private final DataProvider dataProvider;
    private final SearchState searchState;

    private String currentlyPresentedSearchTermText = EMPTY;;

    public SearchBox(DataProvider dataProvider, SearchState searchState) {
        this.dataProvider = dataProvider;
        this.searchState = searchState;
        addClassName(CLASS_NAME);

        getElement().setAttribute("aria-label", "search");
        setPlaceholder("Search");
        setClearButtonVisible(true);
        setAllowCustomValue(true);
        addCustomValueSetListener(this::customValueEntered);
        addSelectedItemChangeListener(this::selectedItemChanged);
        setItems(dataProvider.getSearchTermsDataProvider().findAll());
        setItemLabelGenerator(SearchTerm::getText);
        searchState.addSearchTermChangeListener(this::searchTermChanged);
    }

    private void searchTermChanged(SearchTermChangeEvent searchTermChangeEvent) {
        String oldSearchTermText = searchTermChangeEvent.getOldSearchTermText().orElse(null);
        String newSearchTermText = searchTermChangeEvent.getNewSearchTermText().orElse(null);
        log.info("Search term changed. old search term: {}, new search term: {}", oldSearchTermText, newSearchTermText);
        ensurePresentedValueUpdated(oldSearchTermText, newSearchTermText);
    }

    private void ensurePresentedValueUpdated(String oldSearchTermText, String newSearchTermText) {
        if(!currentlyPresentedSearchTermText.equalsIgnoreCase(newSearchTermText)) {
            log.info("Presented search term text: '{}' is not synced with the new search term text '{}'", currentlyPresentedSearchTermText, newSearchTermText);
            if(oldSearchTermText == null) {
                log.info("Former search term text is empty, which means that the search term change is originated by an external source");
                List<SearchTerm> searchTerms = dataProvider.getSearchTermsDataProvider().findByText(newSearchTermText);
                if (!searchTerms.isEmpty()) {
                    log.info("Search term: '{}' exists", newSearchTermText);
                    setValue(searchTerms.get(0));
                }
                else {
                    log.info("Search term: '{}' does not exist", newSearchTermText);
                    saveNewSearchTerm(newSearchTermText);
                }
            }
            else {
                log.info("Former search term text is not empty, which means that the search term change is originated by this search box (internal)");
            }
        }
        else {
            log.info("Presented search term text '{}' is synced with the new search term text: '{}'", currentlyPresentedSearchTermText, newSearchTermText);
        }
    }

    private void selectedItemChanged(SelectedItemChangeEvent<ComboBox<SearchTerm>> comboBoxSelectedItemChangeEvent) {
        JsonObject selected = comboBoxSelectedItemChangeEvent.getSelectedItem();
        if(selected != null) {
            log.info("Search item selected: {}", selected);
            currentlyPresentedSearchTermText = selected.getString("label");
            navigateToSearchView(currentlyPresentedSearchTermText);
        }
        else {
            log.info("Search selection cleaned");
            currentlyPresentedSearchTermText = EMPTY;
        }
    }

    private void customValueEntered(CustomValueSetEvent<ComboBox<SearchTerm>> customValueSetEvent) {
        currentlyPresentedSearchTermText = customValueSetEvent.getDetail();
        log.info("Search custom value entered: '{}'", currentlyPresentedSearchTermText);
        saveNewSearchTerm(currentlyPresentedSearchTermText);
        navigateToSearchView(currentlyPresentedSearchTermText);
    }

    private void saveNewSearchTerm(String searchTermText) {
        log.info("Saving new search term for text: {}", searchTermText);
        SearchTerm savedSearchTerm = dataProvider.getSearchTermsDataProvider().save(new SearchTerm(searchTermText));
        setItems(dataProvider.getSearchTermsDataProvider().findAll());
        setValue(savedSearchTerm);
    }

    private void navigateToSearchView(String query) {
        Map<String, List<String>> parameters = new HashMap<>();
        parameters.put(QUERY_PARAM_NAME, List.of(query));
        parameters.put(TYPE_PARAM_NAME, List.of("all"));
        QueryParameters queryParameters = new QueryParameters(parameters);
        getUI().ifPresent(ui -> ui.navigate(SearchView.ROUTE, queryParameters));
    }
}
