package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeView.FOLDER;

@CssImport(FOLDER + HomeTab.ID + CSS_FILE_EXTENSION)
public class HomeTab extends Tab {

    public static final String ID = "home-tab";

    private final HomeTabRouterLink homeTabRouterLink;

    public HomeTab() {
        addClassName(ID);
        homeTabRouterLink = new HomeTabRouterLink();
        add(homeTabRouterLink);
    }
}
