package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.UsersDataProvider;

import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoTitleText.ID_SUFFIX;

@CssImport(USER_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoTitleText extends H2 {

    public static final String ID_SUFFIX = "user-view-header-info-title-text";

    private final UsersDataProvider usersDataProvider;

    public UserViewHeaderInfoTitleText(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);
    }

    public void selectedUserChanged(long selectedUserId) {
        setText("Selected User: " + selectedUserId);

        Optional<User> user = usersDataProvider.findById(selectedUserId);
        user.ifPresent(value -> setText(value.getFirstName() + " " + value.getLastName()));
    }
}
