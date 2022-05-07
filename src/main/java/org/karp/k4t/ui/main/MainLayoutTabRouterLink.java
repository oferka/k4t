package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RouterLink;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutTabRouterLink.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutTabRouterLink extends RouterLink {

    public static final String CLASS_NAME = MainLayoutTab.CLASS_NAME + "-router-link";

    private final MainLayoutTabRouterLinkContent mainLayoutTabRouterLinkContent;

    public MainLayoutTabRouterLink(String text, Class<? extends Component> navigationTarget, VaadinIcon vaadinIcon) {
        addClassName(CLASS_NAME);
        setRoute(navigationTarget);
        mainLayoutTabRouterLinkContent = new MainLayoutTabRouterLinkContent(text, vaadinIcon);
        add(mainLayoutTabRouterLinkContent);
    }
}
