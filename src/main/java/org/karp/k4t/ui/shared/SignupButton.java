package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.icon.VaadinIcon.SIGN_IN;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + SignupButton.ID + CSS_FILE_EXTENSION)
public class SignupButton extends Button {

    public static final String ID = "signup-button";

    public SignupButton(DataProvider dataProvider) {
        addClassName(ID);
        addThemeVariants(LUMO_PRIMARY);
        setIcon(SIGN_IN.create());
        setText("Sign up");
        addClickListener(this::signupClicked);
        addClickShortcut(Key.KEY_S, KeyModifier.ALT);
    }

    private void signupClicked(ClickEvent<Button> event) {
        Notification.show("Signup clicked", 3000, MIDDLE);
    }
}
