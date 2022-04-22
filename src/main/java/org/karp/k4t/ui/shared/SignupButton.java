package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.icon.VaadinIcon.SIGN_IN;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@Slf4j
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
        log.info("Signup clicked");
    }
}
