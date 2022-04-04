package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import org.karp.k4t.ui.feed.FeedView;
import org.karp.k4t.ui.home.HomeView;
import org.karp.k4t.ui.views.empty.EmptyView;

import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.feed.FeedView.*;
import static org.karp.k4t.ui.home.HomeView.*;
import static org.karp.k4t.ui.main.MainLayout.ID_PREFIX;
import static org.karp.k4t.ui.main.MainLayoutTabs.ID_SUFFIX;
import static org.karp.k4t.ui.views.empty.EmptyView.*;

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
                new MainLayoutTab(HOME_VIEW_ID, HOME_VIEW_NAME, HomeView.class, HOME_VIEW_ICON),
                new MainLayoutTab(FEED_VIEW_ID, FEED_VIEW_NAME, FeedView.class, FEED_VIEW_ICON),
                new MainLayoutTab(EMPTY_VIEW_ID, EMPTY_VIEW_NAME, EmptyView.class, EMPTY_VIEW_ICON),
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
