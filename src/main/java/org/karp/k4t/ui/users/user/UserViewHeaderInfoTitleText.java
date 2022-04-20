package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.DataProvider;

import java.util.Optional;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderInfoTitleText.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewHeaderInfoTitleText extends H2 {

    public static final String ID = UserViewHeaderInfoTitle.ID + "-text";

    private final DataProvider dataProvider;

    public UserViewHeaderInfoTitleText(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        addClassName(ID);
    }

    public void selectedUserChanged(long selectedUserId) {
        setText("Selected User: " + selectedUserId);
        Optional<User> user = dataProvider.getUsersDataProvider().findById(selectedUserId);
        user.ifPresent(value -> setText(value.getName()));
    }
}
