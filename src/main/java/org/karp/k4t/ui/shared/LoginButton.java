package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.icon.VaadinIcon.USER_CHECK;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@Slf4j
@CssImport(SHARED_FOLDER + LoginButton.CLASS_NAME + CSS_FILE_EXTENSION)
public class LoginButton extends Button {

    public static final String CLASS_NAME = "login-button";

    public LoginButton(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setIcon(USER_CHECK.create());
        setText("Log in");
        addClickListener(this::loginClicked);
        addClickShortcut(Key.KEY_L, KeyModifier.ALT);
    }

    private void loginClicked(ClickEvent<Button> event) {
        log.info("Login clicked");
    }
}
