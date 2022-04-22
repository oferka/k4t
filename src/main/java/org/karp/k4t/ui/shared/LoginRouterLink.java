package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.login.LoginView;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + LoginRouterLink.ID + CSS_FILE_EXTENSION)
public class LoginRouterLink extends RouterLink {

    public static final String ID = "login-router-link";

    private final LoginButton loginButton;

    public LoginRouterLink(DataProvider dataProvider) {
        super(EMPTY, LoginView.class);
        addClassName(ID);

        loginButton = new LoginButton(dataProvider);
        add(loginButton);
    }
}
