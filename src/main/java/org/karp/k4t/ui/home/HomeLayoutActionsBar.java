package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.shared.AuthenticationBar;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutActionsBar.ID + CSS_FILE_EXTENSION)
public class HomeLayoutActionsBar extends HorizontalLayout {

    public static final String ID = HomeLayout.ID + "-actions-bar";

    private final AuthenticationBar authenticationBar;

    public HomeLayoutActionsBar() {
        addClassName(ID);

        authenticationBar = new AuthenticationBar();
        add(authenticationBar);
    }
}
