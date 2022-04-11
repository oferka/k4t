package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.main.MainLayout;
import org.karp.k4t.ui.users.UsersDataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_ID_PREFIX;
import static org.karp.k4t.ui.users.UsersView.USERS_ROUTE;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;

@Route(value = USERS_ROUTE, layout = MainLayout.class)
@PageTitle(UserView.USER_VIEW_NAME)
@CssImport(USER_FOLDER + UserView.USER_VIEW_ID + CSS_FILE_EXTENSION)
public class UserView extends VerticalLayout implements HasUrlParameter<String> {

    public static final String USER_ID_PREFIX = "user";
    public static final String USER_FOLDER = VIEWS_FOLDER + USERS_ID_PREFIX + "/" + USER_ID_PREFIX + "/";
    public static final String USER_ID_SUFFIX = "-view";
    public static final String USER_VIEW_ID = USER_ID_PREFIX + USER_ID_SUFFIX;
    public static final String USER_VIEW_NAME = "User";

    private final UserViewHeader userViewHeader;
    private final UserViewBody userViewBody;
    private final UserViewFooter userViewFooter;

    public UserView(UsersDataProvider usersViewDataProvider) {
        setId(USER_VIEW_ID);
        addClassName(USER_VIEW_ID);

        userViewHeader = new UserViewHeader(usersViewDataProvider);
        add(userViewHeader);

        userViewBody = new UserViewBody(usersViewDataProvider);
        add(userViewBody);

        userViewFooter = new UserViewFooter(usersViewDataProvider);
        add(userViewFooter);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        long selectedUserId = Long.parseLong(parameter);
        selectedUserChanged(selectedUserId);
    }

    private void selectedUserChanged(long selectedUserId) {
        userViewHeader.selectedUserChanged(selectedUserId);
        userViewBody.selectedUserChanged(selectedUserId);
        userViewFooter.selectedUserChanged(selectedUserId);
    }
}
