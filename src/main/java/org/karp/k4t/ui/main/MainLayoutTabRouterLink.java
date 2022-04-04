package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RouterLink;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.main.MainLayout.ID_PREFIX;
import static org.karp.k4t.ui.main.MainLayoutTab.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutTabRouterLink extends RouterLink {

    public static final String VIEW_ID_SUFFIX = "main-view-tab-router-link";
    public static String ID_SUFFIX = "-router-link";

    private final MainLayoutTabRouterLinkContent mainLayoutTabRouterLinkContent;

    public MainLayoutTabRouterLink(String mainViewTabId, String text, Class<? extends Component> navigationTarget, VaadinIcon vaadinIcon) {
        String id = mainViewTabId + ID_SUFFIX;
        setId(id);
        setRoute(navigationTarget);

        mainLayoutTabRouterLinkContent = new MainLayoutTabRouterLinkContent(id, text, vaadinIcon);
        add(mainLayoutTabRouterLinkContent);
    }
}
