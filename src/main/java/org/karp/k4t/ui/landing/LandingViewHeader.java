package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;
import static org.karp.k4t.ui.landing.LandingView.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class LandingViewHeader extends HorizontalLayout {

    public static final String ID = LandingView.ID + "-header";

    private final LandingViewHeaderMenu menu;
    private final LandingViewHeaderSearch search;
    private final LandingViewHeaderActions actions;

    public LandingViewHeader() {
        addClassName(ID);
        setWidthFull();
        setPadding(true);
        setJustifyContentMode(BETWEEN);

        menu = new LandingViewHeaderMenu();
        add(menu);

        search = new LandingViewHeaderSearch();
        add(search);

        actions = new LandingViewHeaderActions();
        add(actions);
    }
}
