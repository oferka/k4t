package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + AuthenticationBar.CLASS_NAME + CSS_FILE_EXTENSION)
public class AuthenticationBar extends HorizontalLayout {

    public static final String CLASS_NAME = "authentication-bar";

    private final LoginRouterLink loginRouterLink;
    private final SignupRouterLink signupRouterLink;

    public AuthenticationBar(DataProvider dataProvider) {
        addClassName(CLASS_NAME);

        loginRouterLink = new LoginRouterLink(dataProvider);
        add(loginRouterLink);

        signupRouterLink = new SignupRouterLink(dataProvider);
        add(signupRouterLink);
    }
}
