package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.DataProvider;

import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoDescription.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoDescription extends Span {

    public static final String ID = UserViewHeaderInfo.ID + "-description";

    private final DataProvider dataProvider;

    public UserViewHeaderInfoDescription(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        addClassName(ID);
    }

    public void selectedUserChanged(long selectedUserId) {
        Optional<User> user = dataProvider.getUsersDataProvider().findById(selectedUserId);
        user.ifPresent(value -> setText("Selected User Name: " + value.getName()));
    }
}
