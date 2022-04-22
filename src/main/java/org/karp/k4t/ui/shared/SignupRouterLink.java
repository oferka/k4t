package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.signup.SignupView;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + SignupRouterLink.ID + CSS_FILE_EXTENSION)
public class SignupRouterLink extends RouterLink {

    public static final String ID = "signup-router-link";

    private final SignupButton signupButton;

    public SignupRouterLink(DataProvider dataProvider) {
        super(EMPTY, SignupView.class);
        addClassName(ID);

        signupButton = new SignupButton(dataProvider);
        add(signupButton);
    }
}
