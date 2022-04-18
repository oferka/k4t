package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderMenu.ID + CSS_FILE_EXTENSION)
public class LandingViewHeaderMenu extends HorizontalLayout {

    public static final String ID = LandingViewHeader.ID + "-menu";

    private final LandingViewHeaderMenuBar menuBar;

    public LandingViewHeaderMenu() {
        addClassName(ID);

        menuBar = new LandingViewHeaderMenuBar();
        add(menuBar);
    }
}
