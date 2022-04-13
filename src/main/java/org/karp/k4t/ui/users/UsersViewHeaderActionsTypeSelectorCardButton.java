package org.karp.k4t.ui.users;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.LIST;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsTypeSelectorCardButton.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsTypeSelectorCardButton extends Button {

    public static final String ID = UsersViewHeaderActionsPresentationTypeSelector.ID + "-card-button";

    public UsersViewHeaderActionsTypeSelectorCardButton(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setIcon(LIST.create());
        addClickShortcut(KEY_C, ALT);
    }
}
