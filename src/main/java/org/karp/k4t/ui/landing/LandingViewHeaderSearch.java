package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderSearch.ID + CSS_FILE_EXTENSION)
public class LandingViewHeaderSearch extends HorizontalLayout {

    public static final String ID = LandingViewHeader.ID + "-search";

    private final LandingViewHeaderSearchBar searchBar;

    public LandingViewHeaderSearch(DataProvider dataProvider) {
        addClassName(ID);
        setAlignItems(CENTER);

        searchBar = new LandingViewHeaderSearchBar(dataProvider);
        add(searchBar);
    }
}
