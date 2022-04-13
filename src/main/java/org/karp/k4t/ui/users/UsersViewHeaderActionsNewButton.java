package org.karp.k4t.ui.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.icon.VaadinIcon.PLUS_CIRCLE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsNewButton.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsNewButton extends Button {

    public static final String ID = UsersViewHeaderActions.ID + "-new-button";

    public UsersViewHeaderActionsNewButton(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setIcon(PLUS_CIRCLE.create());
        setText("New User");
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::newClicked);
        addClickShortcut(Key.KEY_N, KeyModifier.ALT);
    }

    private void newClicked(ClickEvent<Button> event) {
        Notification.show("New Clicked", 3000, MIDDLE);
    }
}
