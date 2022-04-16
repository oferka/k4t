package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserListItemInfoHeaderName.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserListItemInfoHeaderName extends Div {

    public static final String ID = "user-list-item-info-header-name";

    private final UserRouterLink link;

    public UserListItemInfoHeaderName(User user) {
        addClassName(ID);
        link = new UserRouterLink(user);
        add(link);
    }
}
