package org.karp.k4t.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.karp.k4t.ui.home.HomeLayout;
import org.karp.k4t.ui.search.terms.SearchState;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.karp.k4t.ui.SearchView.FOLDER;
import static org.karp.k4t.ui.SearchView.ROUTE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;

@Route(value = ROUTE, layout = HomeLayout.class)
@PageTitle(SearchView.NAME)
@CssImport(FOLDER + SearchView.ID + CSS_FILE_EXTENSION)
public class SearchView extends VerticalLayout implements BeforeEnterObserver {

    public static final String ROUTE = "search";
    public static final String ID_PREFIX = "search";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";
    public static final String NAME = "Search";
    public static final String QUERY_PARAM_NAME = "query";
    public static final String TYPE_PARAM_NAME = "type";

    private final Span viewName;
    private final Span query;
    private final Span type;

    private final SearchState searchState;

    public SearchView(SearchState searchState) {
        this.searchState = searchState;
        addClassName(ID);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        getStyle().set("padding", "2em");

        viewName = new Span(NAME);
        add(viewName);

        query = new Span(searchState.getSearchTerm().isPresent()?searchState.getSearchTerm().get():null);
        add(query);

        type = new Span();
        add(type);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        final QueryParameters queryParameters = beforeEnterEvent.getLocation().getQueryParameters();
        Map<String, List<String>> parameters = queryParameters.getParameters();

        String queryValue = null;
        List<String> queryListValue = parameters.get(QUERY_PARAM_NAME);
        if(queryListValue != null && !queryListValue.isEmpty()) {
            queryValue = queryListValue.get(0);
            query.setText(queryValue);
        }

        String typeValue;
        List<String> typeListValue = parameters.get(TYPE_PARAM_NAME);
        if(typeListValue != null && !typeListValue.isEmpty()) {
            typeValue = typeListValue.get(0);
            type.setText(typeValue);
        }

        searchState.setSearchTerm((queryValue != null)?Optional.of(queryValue):Optional.empty());
    }
}
