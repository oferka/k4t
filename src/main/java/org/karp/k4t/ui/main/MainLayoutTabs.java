package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import org.karp.k4t.ui.feed.FeedView;
import org.karp.k4t.ui.users.UsersView;
import org.karp.k4t.ui.views.empty.EmptyView;

import java.util.Optional;

import static com.vaadin.flow.component.tabs.Tabs.Orientation.VERTICAL;
import static com.vaadin.flow.component.tabs.TabsVariant.LUMO_MINIMAL;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutTabs.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutTabs extends Tabs {

    public static final String CLASS_NAME = MainLayout.ID + "-tabs";

    public MainLayoutTabs() {
        addClassName(CLASS_NAME);
        setOrientation(VERTICAL);
        addThemeVariants(LUMO_MINIMAL);
        add(createTabs());
    }

    private Component[] createTabs() {
        return new Component[] {
                new MainLayoutTab(FeedView.CLASS_NAME, FeedView.NAME, FeedView.class, FeedView.ICON),
                new MainLayoutTab(EmptyView.ID, EmptyView.NAME, EmptyView.class, EmptyView.ICON),
                new MainLayoutTab(UsersView.CLASS_NAME, UsersView.NAME, UsersView.class, UsersView.ICON)
        };
    }

    public void selectTab(Component content) {
        getTabForComponent(content).ifPresent(this::setSelectedTab);
    }

    private Optional<Tab> getTabForComponent(Component content) {
        return getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(content.getClass())).findFirst().map(Tab.class::cast);
    }
}
