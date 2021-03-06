package org.karp.k4t.ui.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;

import static com.vaadin.flow.component.Key.KEY_C;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.icon.VaadinIcon.BULLETS;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsTypeSelectorListButton.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersViewPresentationMode.LIST;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsTypeSelectorListButton extends Button {

    public static final String CLASS_NAME = UsersViewHeaderActionsPresentationTypeSelector.CLASS_NAME + "-list-button";

    private final UsersViewState usersViewState;

    public UsersViewHeaderActionsTypeSelectorListButton(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        this.usersViewState = usersViewState;
        addClassName(CLASS_NAME);
        setIcon(BULLETS.create());
        addClickShortcut(KEY_C, ALT);
        addClickListener(this::cardPresentationTypeClicked);
    }

    private void cardPresentationTypeClicked(ClickEvent<Button> event) {
        usersViewState.setPresentationMode(LIST);
    }
}
