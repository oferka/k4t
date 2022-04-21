package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.QueryParameters;
import elemental.json.JsonObject;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.SearchView;
import org.karp.k4t.ui.search.terms.SearchState;
import org.karp.k4t.ui.search.terms.SearchTermChangeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static java.lang.String.format;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + SearchBox.ID + CSS_FILE_EXTENSION)
public class SearchBox extends ComboBox<SearchTerm> {

    public static final String ID = "search-box";

    private final DataProvider dataProvider;
    private final SearchState searchState;

    public SearchBox(DataProvider dataProvider, SearchState searchState) {
        this.dataProvider = dataProvider;
        this.searchState = searchState;
        addClassName(ID);

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
        Optional<SearchTerm> oldSearchTerm = searchTermChangeEvent.getOldSearchTerm();
        Optional<SearchTerm> newSearchTerm = searchTermChangeEvent.getNewSearchTerm();
        String oldSearchTermText = oldSearchTerm.map(SearchTerm::getText).orElse(null);
        String newSearchTermText = newSearchTerm.map(SearchTerm::getText).orElse(null);
        Notification.show(format("Search term changed. old search term: %s, new search term: %s", oldSearchTermText, newSearchTermText), 3000, MIDDLE);
    }

    private void selectedItemChanged(SelectedItemChangeEvent<ComboBox<SearchTerm>> comboBoxSelectedItemChangeEvent) {
        JsonObject selected = comboBoxSelectedItemChangeEvent.getSelectedItem();
        if(selected != null) {
            Notification.show("Search item selected: " + selected, 3000, MIDDLE);
            String label = selected.getString("label");
            navigateToSearchView(label);
        }
        else {
            Notification.show("Search selection cleaned", 3000, MIDDLE);
        }
    }

    private void customValueEntered(CustomValueSetEvent<ComboBox<SearchTerm>> customValueSetEvent) {
        String customValue = customValueSetEvent.getDetail();
        Notification.show("Search custom value entered: " + customValue, 3000, MIDDLE);
        navigateToSearchView(customValue);
    }

    private void navigateToSearchView(String query) {
        Map<String, List<String>> parameters = new HashMap<>();
        parameters.put("query", List.of(query));
        parameters.put("type", List.of("all"));
        QueryParameters queryParameters = new QueryParameters(parameters);
        getUI().ifPresent(ui -> ui.navigate(SearchView.ROUTE, queryParameters));

        List<SearchTerm> searchTermList = dataProvider.getSearchTermsDataProvider().findByText(query);
        Optional<SearchTerm> searchTerm = Optional.empty();
        if(!searchTermList.isEmpty()) {
            searchTerm = Optional.of(searchTermList.get(0));
        }
        searchState.setSearchTerm(searchTerm);
    }
}
