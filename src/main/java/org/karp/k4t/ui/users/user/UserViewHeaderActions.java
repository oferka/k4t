package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.users.UsersDataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderActions.ID_SUFFIX;

@CssImport(USER_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UserViewHeaderActions extends HorizontalLayout {

    public static final String ID_SUFFIX = "user-view-header-actions";

    private final UserViewHeaderActionsShareButton userViewHeaderActionsShareButton;
    private final UserViewHeaderActionsExportButton userViewHeaderActionsExportButton;

    public UserViewHeaderActions(UsersDataProvider usersDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        userViewHeaderActionsShareButton = new UserViewHeaderActionsShareButton(usersDataProvider);
        add(userViewHeaderActionsShareButton);

        userViewHeaderActionsExportButton = new UserViewHeaderActionsExportButton(usersDataProvider);
        add(userViewHeaderActionsExportButton);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderActionsShareButton.selectedUserChanged(selectedUserId);
        userViewHeaderActionsExportButton.selectedUserChanged(selectedUserId);
    }
}
