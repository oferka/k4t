package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.icon.VaadinIcon.USER_CHECK;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + LoginButton.ID + CSS_FILE_EXTENSION)
public class LoginButton extends Button {

    public static final String ID = "login-button";

    public LoginButton() {
        addClassName(ID);
        setIcon(USER_CHECK.create());
        setText("Log in");
        addClickListener(this::loginClicked);
        addClickShortcut(Key.KEY_L, KeyModifier.ALT);
    }

    private void loginClicked(ClickEvent<Button> event) {
        Notification.show("Login clicked", 3000, MIDDLE);
    }
}
