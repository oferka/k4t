package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.karp.k4t.ui.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfo.ID;

@CssImport(USER_FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewHeaderInfo extends VerticalLayout {

    public static final String ID = UserViewHeader.ID + "-info";

    private final UserViewHeaderInfoTitle userViewHeaderInfoTitle;
    private final UserViewHeaderInfoDescription userViewHeaderInfoDescription;

    public UserViewHeaderInfo(UsersDataProvider usersDataProvider) {
        addClassName(ID);

        setAlignItems(CENTER);

        userViewHeaderInfoTitle = new UserViewHeaderInfoTitle(usersDataProvider);
        add(userViewHeaderInfoTitle);

        userViewHeaderInfoDescription = new UserViewHeaderInfoDescription(usersDataProvider);
        add(userViewHeaderInfoDescription);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderInfoTitle.selectedUserChanged(selectedUserId);
        userViewHeaderInfoDescription.selectedUserChanged(selectedUserId);
    }
}
