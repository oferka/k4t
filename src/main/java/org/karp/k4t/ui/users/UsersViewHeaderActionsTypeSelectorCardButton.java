package org.karp.k4t.ui.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.LIST;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_ID_PREFIX;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsTypeSelectorCardButton.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + USERS_ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsTypeSelectorCardButton extends Button {

    public static final String ID_SUFFIX = "users-view-header-actions-presentation-type-selector-card-button";

    public UsersViewHeaderActionsTypeSelectorCardButton() {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setIcon(LIST.create());
        addClickListener(this::cardPresentationTypeClicked);
        addClickShortcut(KEY_C, ALT);
    }

    private void cardPresentationTypeClicked(ClickEvent<Button> event) {
        Notification.show("Card Presentation Type Clicked", 3000, MIDDLE);
    }
}
