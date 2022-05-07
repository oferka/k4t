package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.feed.FeedView;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingView.CLASS_NAME + CSS_FILE_EXTENSION)
public class LandingViewBody extends VerticalLayout {

    public static final String CLASS_NAME = LandingView.CLASS_NAME + "-body";

    public LandingViewBody(DataProvider dataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(Alignment.CENTER);
        add(new H2("Landing Page Body"));
        add(new RouterLink("Feed", FeedView.class));
    }
}
