package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsPresentationTypeSelector.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String ID = UsersViewHeaderActions.ID + "-presentation-type-selector";

    private final UsersViewHeaderActionsTypeSelectorGridButton usersViewHeaderActionsTypeSelectorGridButton;
    private final UsersViewHeaderActionsTypeSelectorCardButton usersViewHeaderActionsTypeSelectorCardButton;

    public UsersViewHeaderActionsPresentationTypeSelector(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        setSpacing(false);

        usersViewHeaderActionsTypeSelectorGridButton = new UsersViewHeaderActionsTypeSelectorGridButton(usersViewDataProvider);
        add(usersViewHeaderActionsTypeSelectorGridButton);

        usersViewHeaderActionsTypeSelectorCardButton = new UsersViewHeaderActionsTypeSelectorCardButton(usersViewDataProvider);
        add(usersViewHeaderActionsTypeSelectorCardButton);
    }
}
