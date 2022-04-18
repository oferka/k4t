package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.landing.LandingView;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeView.FOLDER;

@CssImport(FOLDER + HomeTabRouterLink.ID + CSS_FILE_EXTENSION)
public class HomeTabRouterLink extends RouterLink {

    public static final String ID = HomeTab.ID + "-router-link";

    public HomeTabRouterLink() {
        addClassName(ID);
        setRoute(LandingView.class);
        setText("Home");
    }
}
