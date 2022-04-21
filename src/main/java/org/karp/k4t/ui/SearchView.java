package org.karp.k4t.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.karp.k4t.ui.home.HomeLayout;

import java.util.List;
import java.util.Map;

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

    private final Span viewName;
    private final Span query;
    private final Span type;

    public SearchView() {
        addClassName(ID);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        getStyle().set("padding", "2em");

        viewName = new Span(NAME);
        add(viewName);

        query = new Span();
        add(query);

        type = new Span();
        add(type);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        final QueryParameters queryParameters = beforeEnterEvent.getLocation().getQueryParameters();
        Map<String, List<String>> parameters = queryParameters.getParameters();
        List<String> queryListValue = parameters.get("query");
        if(queryListValue != null && !queryListValue.isEmpty()) {
            String queryValue = queryListValue.get(0);
            query.setText(queryValue);
        }
        List<String> typeListValue = parameters.get("type");
        if(typeListValue != null && !typeListValue.isEmpty()) {
            String typeValue = typeListValue.get(0);
            type.setText(typeValue);
        }
    }
}
