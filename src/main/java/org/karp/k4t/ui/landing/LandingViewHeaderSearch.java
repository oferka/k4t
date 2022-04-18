package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderSearch.ID + CSS_FILE_EXTENSION)
public class LandingViewHeaderSearch extends HorizontalLayout {

    public static final String ID = LandingViewHeader.ID + "-search";

    private final LandingViewHeaderSearchBar searchBar;

    public LandingViewHeaderSearch() {
        addClassName(ID);
        setAlignItems(CENTER);

        searchBar = new LandingViewHeaderSearchBar();
        add(searchBar);
    }
}
