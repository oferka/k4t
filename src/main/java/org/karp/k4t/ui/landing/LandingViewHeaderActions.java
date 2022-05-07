package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderActions.CLASS_NAME + CSS_FILE_EXTENSION)
public class LandingViewHeaderActions extends HorizontalLayout {

    public static final String CLASS_NAME = LandingViewHeader.CLASS_NAME + "-actions";

    public LandingViewHeaderActions(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        add(new H3("LandingViewHeaderActions"));
    }
}
