package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItemInfoHeaderName.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersListItemInfoHeaderName extends Div {

    public static final String CLASS_NAME = UsersListItemInfoHeader.CLASS_NAME + "-name";

    private final UserRouterLink link;

    public UsersListItemInfoHeaderName(User user) {
        addClassName(CLASS_NAME);
        link = new UserRouterLink(user);
        add(link);
    }
}
