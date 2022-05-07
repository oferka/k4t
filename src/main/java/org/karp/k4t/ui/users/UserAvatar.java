package org.karp.k4t.ui.users;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.dom.DomEvent;
import org.karp.k4t.model.User;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserAvatar.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UserAvatar extends Avatar {

    public static final String CLASS_NAME = "user-avatar";

    public UserAvatar(User user) {
        addClassName(CLASS_NAME);
        getElement().addEventListener("click", this::avatarClicked);
        setUser(user);
    }

    public void selectedUserChanged(User user) {
        setUser(user);
    }

    public void setUser(User user) {
        if(user != null) {
            setImage(user.getThumbnailPicture());
            setName(user.getName());
        }
    }

    private void avatarClicked(DomEvent event) {
        Notification.show("Avatar clicked", 3000, MIDDLE);
    }
}
