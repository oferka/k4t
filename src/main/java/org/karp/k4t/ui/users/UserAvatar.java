package org.karp.k4t.ui.users;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.dom.DomEvent;
import org.karp.k4t.model.User;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserAvatar.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserAvatar extends Avatar {

    public static final String ID = "user-avatar";

    public UserAvatar(User user) {
        addClassName(ID);
        getElement().addEventListener("click", this::avatarClicked);
        setUser(user);
    }

    public void selectedUserChanged(User user) {
        setUser(user);
    }

    public void setUser(User user) {
        if(user != null) {
            setImage(user.getThumbnailPicture());
            setName(user.getFirstName() + " " + user.getLastName());
        }
    }

    private void avatarClicked(DomEvent event) {
        Notification.show("Avatar clicked", 3000, MIDDLE);
    }
}
