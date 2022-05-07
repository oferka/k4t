package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.karp.k4t.ui.DataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingView.CLASS_NAME + CSS_FILE_EXTENSION)
public class LandingViewFooter extends VerticalLayout {

    public static final String CLASS_NAME = LandingView.CLASS_NAME + "-footer";

    public LandingViewFooter(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setAlignItems(Alignment.CENTER);

        add(new H3("Landing Page Footer"));
    }
}
