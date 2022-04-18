package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tabs;

import static com.vaadin.flow.component.tabs.Tabs.Orientation.HORIZONTAL;
import static com.vaadin.flow.component.tabs.TabsVariant.LUMO_MINIMAL;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderNavigationTabs.ID + CSS_FILE_EXTENSION)
public class LandingViewHeaderNavigationTabs extends Tabs {

    public static final String ID = LandingViewHeaderNavigation.ID + "-tabs";

    public LandingViewHeaderNavigationTabs() {
        addClassName(ID);
        setOrientation(HORIZONTAL);
        addThemeVariants(LUMO_MINIMAL);

//        add(createTabs());
    }

//    private Component[] createTabs() {
//        return new Component[] {
//                new MainLayoutTab(HomeView.ID, HomeView.NAME, HomeView.class, HomeView.ICON),
//                new MainLayoutTab(EmptyView.ID, EmptyView.NAME, EmptyView.class, EmptyView.ICON),
//                new MainLayoutTab(UsersView.ID, UsersView.NAME, UsersView.class, UsersView.ICON)
//        };
//    }

//    public void selectTab(Component content) {
//        getTabForComponent(content).ifPresent(this::setSelectedTab);
//    }
//
//    private Optional<Tab> getTabForComponent(Component content) {
//        return getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(content.getClass())).findFirst().map(Tab.class::cast);
//    }
}
