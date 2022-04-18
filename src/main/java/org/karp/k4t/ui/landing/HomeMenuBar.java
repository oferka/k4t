package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.RouterLink;

import static com.vaadin.flow.component.menubar.MenuBarVariant.LUMO_SMALL;
import static com.vaadin.flow.component.menubar.MenuBarVariant.LUMO_TERTIARY;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderNavigation.ID + CSS_FILE_EXTENSION)
public class HomeMenuBar extends MenuBar {

    public static final String ID = "home-menu-bar";

    public HomeMenuBar() {
        addClassName(ID);
        addThemeVariants(LUMO_SMALL, LUMO_TERTIARY);
//        MenuItem homeMenuItem = addItem("Home", e -> homeClicked());
        RouterLink homeRouterLink = new RouterLink("Home", LandingView.class);
        homeRouterLink.addClassName("home-router-link");
        MenuItem homeMenuItem = addItem(homeRouterLink, e -> homeClicked());
    }

    private void homeClicked() {
        Notification.show("Home clicked", 3000, MIDDLE);
    }
}
