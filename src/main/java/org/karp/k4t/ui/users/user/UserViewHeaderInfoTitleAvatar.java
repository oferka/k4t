package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.users.UserAvatar;

import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoTitleAvatar.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoTitleAvatar extends HorizontalLayout {

    public static final String CLASS_NAME = UserViewHeaderInfoTitle.CLASS_NAME + "-avatar";

    private final UserAvatar userAvatar;
    private final DataProvider dataProvider;

    public UserViewHeaderInfoTitleAvatar(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        addClassName(CLASS_NAME);
        userAvatar = new UserAvatar(null);
        add(userAvatar);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<User> user = dataProvider.getUsersDataProvider().findById(selectedUserId);
        if(user.isPresent()) {
            userAvatar.selectedUserChanged(user.get());
        }
    }
}
