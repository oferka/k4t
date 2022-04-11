package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeader.ID;

@CssImport(USER_FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewHeader extends HorizontalLayout {

    public static final String ID = UserView.ID + "-header";

    private final UserViewHeaderInfo userViewHeaderInfo;
    private final UserViewHeaderActions userViewHeaderActions;

    public UserViewHeader(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        userViewHeaderInfo = new UserViewHeaderInfo(usersViewDataProvider);
        add(userViewHeaderInfo);

        userViewHeaderActions = new UserViewHeaderActions(usersViewDataProvider);
        add(userViewHeaderActions);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderInfo.selectedUserChanged(selectedUserId);
        userViewHeaderActions.selectedUserChanged(selectedUserId);
    }
}
