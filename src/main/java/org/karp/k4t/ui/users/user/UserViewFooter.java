package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewFooter.ID;

@CssImport(USER_FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewFooter extends HorizontalLayout {

    public static final String ID = UserView.ID + "-footer";

    private final H2 label;

    public UserViewFooter(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        label = new H2("say what again");
        add(label);
    }

    public void selectedUserChanged(long selectedUserId) {
        label.setText("Selected User: " + selectedUserId);
    }
}
