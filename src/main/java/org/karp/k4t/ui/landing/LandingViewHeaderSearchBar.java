package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.textfield.TextField;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.icon.VaadinIcon.SEARCH;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderSearch.CLASS_NAME + CSS_FILE_EXTENSION)
public class LandingViewHeaderSearchBar extends TextField {

    public static final String CLASS_NAME = LandingViewHeaderSearch.CLASS_NAME + "-bar";

    public LandingViewHeaderSearchBar(DataProvider dataProvider) {
        addClassName(CLASS_NAME);

        getElement().setAttribute("aria-label", "search");
        setPlaceholder("Search");
        setClearButtonVisible(true);
        setPrefixComponent(SEARCH.create());
    }
}
