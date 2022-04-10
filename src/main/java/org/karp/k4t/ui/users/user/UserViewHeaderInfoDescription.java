package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.UsersDataProvider;

import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoDescription.ID_SUFFIX;

@CssImport(USER_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoDescription extends Span {

    public static final String ID_SUFFIX = "user-view-header-info-description";

    private final UsersDataProvider usersDataProvider;

    public UserViewHeaderInfoDescription(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<User> user = usersDataProvider.findById(selectedUserId);
        user.ifPresent(value -> setText("Selected User First Name: " + value.getFirstName()));
    }
}
