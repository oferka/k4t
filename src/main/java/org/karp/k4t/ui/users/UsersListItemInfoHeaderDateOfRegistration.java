package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItemInfoHeaderDateOfRegistration.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersListItemInfoHeaderDateOfRegistration extends Div {

    public static final String ID = UsersListItemInfoHeader.ID + "-date-of-registration";

    private final UserDateOfRegistration dateOfRegistration;

    public UsersListItemInfoHeaderDateOfRegistration(User user) {
        addClassNames(ID);
        dateOfRegistration = new UserDateOfRegistration(user);
        add(dateOfRegistration);
    }
}
