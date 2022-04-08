package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_ID_PREFIX;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsPresentationTypeSelector.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + USERS_ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String ID_SUFFIX = "users-view-header-actions-presentation-type-selector";

    private final UsersViewHeaderActionsTypeSelectorGridButton usersViewHeaderActionsTypeSelectorGridButton;
    private final UsersViewHeaderActionsTypeSelectorCardButton usersViewHeaderActionsTypeSelectorCardButton;

    public UsersViewHeaderActionsPresentationTypeSelector() {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setSpacing(false);

        usersViewHeaderActionsTypeSelectorGridButton = new UsersViewHeaderActionsTypeSelectorGridButton();
        add(usersViewHeaderActionsTypeSelectorGridButton);

        usersViewHeaderActionsTypeSelectorCardButton = new UsersViewHeaderActionsTypeSelectorCardButton();
        add(usersViewHeaderActionsTypeSelectorCardButton);
    }
}
