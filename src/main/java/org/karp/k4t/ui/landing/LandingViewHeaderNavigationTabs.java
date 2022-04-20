package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tabs;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.tabs.Tabs.Orientation.HORIZONTAL;
import static com.vaadin.flow.component.tabs.TabsVariant.LUMO_MINIMAL;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderNavigationTabs.ID + CSS_FILE_EXTENSION)
public class LandingViewHeaderNavigationTabs extends Tabs {

    public static final String ID = LandingViewHeaderNavigation.ID + "-tabs";

    public LandingViewHeaderNavigationTabs(DataProvider dataProvider) {
        addClassName(ID);
        setOrientation(HORIZONTAL);
        addThemeVariants(LUMO_MINIMAL);
    }
}
