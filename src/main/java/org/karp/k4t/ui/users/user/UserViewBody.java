package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.users.UsersDataProvider;
import org.karp.k4t.ui.users.UsersView;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewBody.ID_SUFFIX;

@CssImport(USER_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UserViewBody extends VerticalLayout {

    public static final String ID_SUFFIX = "user-view-body";

    private final Label selectedIdLabel;
    private final RouterLink usersRouterLink;

    public UserViewBody(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setHeightFull();
        setAlignItems(FlexComponent.Alignment.CENTER);

        selectedIdLabel = new Label();
        add(selectedIdLabel);

        usersRouterLink = new RouterLink(UsersView.USERS_VIEW_NAME, UsersView.class);
        add(usersRouterLink);
    }

    public void selectedUserChanged(long selectedUserId) {
        selectedIdLabel.setText("Selected User: " + selectedUserId);
    }
}
