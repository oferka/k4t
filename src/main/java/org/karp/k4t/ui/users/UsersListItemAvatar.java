package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItemAvatar.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersListItemAvatar extends Div {

    public static final String ID = UsersListItem.CLASS_NAME + "-avatar";

    private final UserAvatar userAvatar;

    public UsersListItemAvatar(User user) {
        addClassNames(ID);
        userAvatar = new UserAvatar(user);
        add(userAvatar);
    }
}
