package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActions.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderActions extends HorizontalLayout {

    public static final String ID = UsersViewHeader.ID + "-actions";

    private final UsersViewHeaderActionsPresentationTypeSelector usersViewHeaderActionsPresentationTypeSelector;
    private final UsersViewHeaderActionsFilterButton usersViewHeaderActionsFilterButton;
    private final UsersViewHeaderActionsNewButton usersViewHeaderActionsNewButton;

    public UsersViewHeaderActions(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        usersViewHeaderActionsPresentationTypeSelector = new UsersViewHeaderActionsPresentationTypeSelector(usersViewDataProvider);
        add(usersViewHeaderActionsPresentationTypeSelector);

        usersViewHeaderActionsFilterButton = new UsersViewHeaderActionsFilterButton(usersViewDataProvider);
        add(usersViewHeaderActionsFilterButton);

        usersViewHeaderActionsNewButton = new UsersViewHeaderActionsNewButton(usersViewDataProvider);
        add(usersViewHeaderActionsNewButton);
    }
}
