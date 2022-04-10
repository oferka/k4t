package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeader.ID_SUFFIX;

@CssImport(USER_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UserViewHeader extends HorizontalLayout {

    public static final String ID_SUFFIX = "user-view-header";

    private final H2 label;

    public UserViewHeader(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setWidthFull();
        setAlignItems(CENTER);

        label = new H2("say what again");
        add(label);
    }

    public void selectedUserChanged(long selectedUserId) {
        label.setText("Selected User: " + selectedUserId);
    }
}
