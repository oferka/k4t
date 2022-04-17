package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.home.HomeView;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;
import static org.karp.k4t.ui.landing.LandingView.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class LandingViewBody extends VerticalLayout {

    public static final String ID = LandingView.ID + "-body";

    public LandingViewBody() {
        addClassName(ID);

        setAlignItems(Alignment.CENTER);
        add(new H2("Landing Page Body"));
        add(new RouterLink("Home", HomeView.class));
    }
}
