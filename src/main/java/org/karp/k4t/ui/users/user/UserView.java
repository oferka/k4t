package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.main.MainLayout;
import org.karp.k4t.ui.users.UsersView;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.ROUTE;
import static org.karp.k4t.ui.users.user.UserView.CLASS_NAME;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;

@Route(value = ROUTE, layout = MainLayout.class)
@PageTitle(UserView.NAME)
@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UserView extends VerticalLayout implements HasUrlParameter<Long> {

    public static final String ID_PREFIX = "user";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String FOLDER = UsersView.FOLDER + ID_PREFIX + "/";
    public static final String NAME = "User";

    private final UserViewHeader userViewHeader;
    private final UserViewBody userViewBody;
    private final UserViewFooter userViewFooter;

    public UserView(DataProvider dataProvider) {
        addClassName(CLASS_NAME);

        userViewHeader = new UserViewHeader(dataProvider);
        add(userViewHeader);

        userViewBody = new UserViewBody(dataProvider);
        addAndExpand(userViewBody);

        userViewFooter = new UserViewFooter(dataProvider);
        add(userViewFooter);
    }

    @Override
    public void setParameter(BeforeEvent event, Long parameter) {
        setUser(parameter);
    }

    private void setUser(long selectedUserId) {
        userViewHeader.selectedUserChanged(selectedUserId);
        userViewBody.selectedUserChanged(selectedUserId);
        userViewFooter.selectedUserChanged(selectedUserId);
    }
}
