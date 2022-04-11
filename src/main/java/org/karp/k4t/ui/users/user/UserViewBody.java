package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.users.UsersDataProvider;
import org.karp.k4t.ui.users.UsersView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewBody.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewBody extends VerticalLayout {

    public static final String ID = UserView.ID + "-body";

    private final Label selectedIdLabel;
    private final RouterLink usersRouterLink;

    public UserViewBody(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        selectedIdLabel = new Label();
        add(selectedIdLabel);

        usersRouterLink = new RouterLink(UsersView.NAME, UsersView.class);
        add(usersRouterLink);
    }

    public void selectedUserChanged(long selectedUserId) {
        selectedIdLabel.setText("Selected User: " + selectedUserId);
    }
}
