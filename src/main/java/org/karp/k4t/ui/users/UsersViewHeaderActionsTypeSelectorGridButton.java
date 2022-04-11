package org.karp.k4t.ui.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.Key.KEY_G;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.TABLE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsTypeSelectorGridButton.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsTypeSelectorGridButton extends Button {

    public static final String ID = UsersViewHeaderActionsPresentationTypeSelector.ID + "-grid-button";

    public UsersViewHeaderActionsTypeSelectorGridButton(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        setIcon(TABLE.create());
        addClickListener(this::gridPresentationTypeClicked);
        addClickShortcut(KEY_G, ALT);
    }

    private void gridPresentationTypeClicked(ClickEvent<Button> event) {
        Notification.show("Grid Presentation Type Clicked", 3000, MIDDLE);
    }
}
