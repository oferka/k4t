package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + AuthenticationBar.ID + CSS_FILE_EXTENSION)
public class AuthenticationBar extends HorizontalLayout {

    public static final String ID = "authentication-bar";

    private final LoginButton loginButton;
    private final SignupButton signupButton;

    public AuthenticationBar() {
        addClassName(ID);

        loginButton = new LoginButton();
        add(loginButton);

        signupButton = new SignupButton();
        add(signupButton);
    }
}
