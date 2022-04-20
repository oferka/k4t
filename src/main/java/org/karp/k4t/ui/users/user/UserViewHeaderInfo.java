package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfo.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewHeaderInfo extends VerticalLayout {

    public static final String ID = UserViewHeader.ID + "-info";

    private final UserViewHeaderInfoTitle userViewHeaderInfoTitle;
    private final UserViewHeaderInfoDescription userViewHeaderInfoDescription;

    public UserViewHeaderInfo(DataProvider dataProvider) {
        addClassName(ID);

        setAlignItems(CENTER);

        userViewHeaderInfoTitle = new UserViewHeaderInfoTitle(dataProvider);
        add(userViewHeaderInfoTitle);

        userViewHeaderInfoDescription = new UserViewHeaderInfoDescription(dataProvider);
        add(userViewHeaderInfoDescription);
    }

    public void selectedUserChanged(long selectedUserId) {
        userViewHeaderInfoTitle.selectedUserChanged(selectedUserId);
        userViewHeaderInfoDescription.selectedUserChanged(selectedUserId);
    }
}
