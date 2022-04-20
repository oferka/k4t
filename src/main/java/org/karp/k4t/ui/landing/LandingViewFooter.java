package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.karp.k4t.ui.DataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;
import static org.karp.k4t.ui.landing.LandingView.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class LandingViewFooter extends VerticalLayout {

    public static final String ID = LandingView.ID + "-footer";

    public LandingViewFooter(DataProvider dataProvider) {
        addClassName(ID);
        setAlignItems(Alignment.CENTER);

        add(new H3("Landing Page Footer"));
    }
}
