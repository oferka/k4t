package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserListItemInfoHeaderDateOfRegistration.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserListItemInfoHeaderDateOfRegistration extends Div {

    public static final String ID = "user-list-item-info-header-date-of-registration";

    private final UserDateOfRegistration dateOfRegistration;

    public UserListItemInfoHeaderDateOfRegistration(User user) {
        addClassNames(ID);
        dateOfRegistration = new UserDateOfRegistration(user);
        add(dateOfRegistration);
    }
}
