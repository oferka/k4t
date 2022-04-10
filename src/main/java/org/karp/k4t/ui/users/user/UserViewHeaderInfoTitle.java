package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoTitle.ID_SUFFIX;

@CssImport(USER_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoTitle extends HorizontalLayout {

    public static final String ID_SUFFIX = "user-view-header-info-title";

    private final UserViewHeaderInfoTitleAvatar userViewHeaderInfoTitleIcon;
    private final UserViewHeaderInfoTitleText userViewHeaderInfoTitleText;

    public UserViewHeaderInfoTitle(UsersDataProvider usersDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setAlignItems(CENTER);

        userViewHeaderInfoTitleIcon = new UserViewHeaderInfoTitleAvatar(usersDataProvider);
        add(userViewHeaderInfoTitleIcon);

        userViewHeaderInfoTitleText = new UserViewHeaderInfoTitleText(usersDataProvider);
        add(userViewHeaderInfoTitleText);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderInfoTitleIcon.selectedUserChanged(selectedUserId);
        userViewHeaderInfoTitleText.selectedUserChanged(selectedUserId);
    }
}
