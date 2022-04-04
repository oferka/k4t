package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import org.karp.k4t.ui.feed.FeedView;
import org.karp.k4t.ui.home.HomeView;

import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.main.MainLayout.ID_PREFIX;
import static org.karp.k4t.ui.main.MainLayoutTabs.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutTabs extends Tabs {

    public static final String ID_SUFFIX = "main-layout-tabs";

    public MainLayoutTabs() {
        setId(ID_SUFFIX);
        setOrientation(Tabs.Orientation.VERTICAL);
        addThemeVariants(TabsVariant.LUMO_MINIMAL);
        add(createTabs());
    }

    private Component[] createTabs() {
        return new Component[] {
                new MainLayoutTab(HomeView.HOME_VIEW_ID, HomeView.HOME_VIEW_NAME, HomeView.class, HomeView.HOME_VIEW_ICON),
                new MainLayoutTab(FeedView.FEED_VIEW_ID, FeedView.FEED_VIEW_NAME, FeedView.class, FeedView.FEED_VIEW_ICON),
//                new MainViewTab(EMPLOYEE)
        };
    }

    public void selectTab(Component content) {
        getTabForComponent(content).ifPresent(this::setSelectedTab);
    }

    private Optional<Tab> getTabForComponent(Component content) {
        return getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(content.getClass())).findFirst().map(Tab.class::cast);
    }
}
