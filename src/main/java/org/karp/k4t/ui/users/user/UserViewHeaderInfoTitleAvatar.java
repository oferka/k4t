package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.UserAvatar;
import org.karp.k4t.ui.users.UsersDataProvider;

import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoTitleAvatar.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoTitleAvatar extends HorizontalLayout {

    public static final String ID = UserViewHeaderInfoTitle.ID + "-avatar";

    private final UserAvatar userAvatar;
    private final UsersDataProvider usersDataProvider;

    public UserViewHeaderInfoTitleAvatar(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(ID);
        userAvatar = new UserAvatar(null);
        add(userAvatar);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<User> user = usersDataProvider.findById(selectedUserId);
        if(user.isPresent()) {
            userAvatar.selectedUserChanged(user.get());
        }
    }
}
