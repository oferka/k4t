package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoTitle.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeaderInfo.CLASS_NAME + "-title";

    private final UserViewHeaderInfoTitleAvatar userViewHeaderInfoTitleIcon;
    private final UserViewHeaderInfoTitleText userViewHeaderInfoTitleText;

    public UserViewHeaderInfoTitle(DataProvider dataProvider) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        userViewHeaderInfoTitleIcon = new UserViewHeaderInfoTitleAvatar(dataProvider);
        add(userViewHeaderInfoTitleIcon);

        userViewHeaderInfoTitleText = new UserViewHeaderInfoTitleText(dataProvider);
        add(userViewHeaderInfoTitleText);

        setVerticalComponentAlignment(CENTER, userViewHeaderInfoTitleIcon, userViewHeaderInfoTitleText);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderInfoTitleIcon.selectedUserChanged(selectedUserId);
        userViewHeaderInfoTitleText.selectedUserChanged(selectedUserId);
    }
}
