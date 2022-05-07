package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.shared.AuthenticationBar;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutActionsBar.CLASS_NAME + CSS_FILE_EXTENSION)
public class HomeLayoutActionsBar extends HorizontalLayout {

    public static final String CLASS_NAME = HomeLayout.ID + "-actions-bar";

    private final AuthenticationBar authenticationBar;

    public HomeLayoutActionsBar(DataProvider dataProvider) {
        addClassName(CLASS_NAME);

        authenticationBar = new AuthenticationBar(dataProvider);
        add(authenticationBar);
    }
}
