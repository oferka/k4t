package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.dom.DomEvent;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.UsersDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoTitleAvatar.ID_SUFFIX;

@CssImport(USER_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoTitleAvatar extends Avatar {

    public static final String ID_SUFFIX = "user-view-header-info-title-avatar";

    private final UsersDataProvider usersDataProvider;

    public UserViewHeaderInfoTitleAvatar(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        getElement().addEventListener("click", this::avatarClicked);
    }

    private void avatarClicked(DomEvent event) {
        Notification.show("User avatar clicked", 3000, MIDDLE);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<User> user = usersDataProvider.findById(selectedUserId);
        if(user.isPresent()) {
            setImage("https://randomuser.me/api/portraits/thumb/men/40.jpg");
            setName(user.get().getFirstName());
        }
    }
}
