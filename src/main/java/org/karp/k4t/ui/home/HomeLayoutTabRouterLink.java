package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.RouterLink;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTabRouterLink.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTabRouterLink extends RouterLink {

    public static final String ID = HomeLayoutTab.ID + "-router-link";

    private final HomeLayoutTabRouterLinkContent homeLayoutTabRouterLinkContent;

    public HomeLayoutTabRouterLink(String text, Class<? extends Component> navigationTarget, VaadinIcon vaadinIcon) {
        addClassName(ID);
        setRoute(navigationTarget);
        homeLayoutTabRouterLinkContent = new HomeLayoutTabRouterLinkContent(text, vaadinIcon);
        add(homeLayoutTabRouterLinkContent);
    }
}
