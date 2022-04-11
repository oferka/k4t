package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.main.MainLayout;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersView.ID;

@Route(value = UsersView.ROUTE, layout = MainLayout.class)
@PageTitle(UsersView.NAME)
@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersView extends VerticalLayout {

    public static final String ROUTE = "users";
    public static final String ID_PREFIX = "users";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Users";
    public static final VaadinIcon ICON = USERS;

    private final UsersViewHeader usersViewHeader;
    private final UsersViewBody usersViewBody;
    private final UsersViewFooter usersViewFooter;

    public UsersView(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        usersViewHeader = new UsersViewHeader(usersViewDataProvider);
        add(usersViewHeader);

        usersViewBody = new UsersViewBody(usersViewDataProvider);
        add(usersViewBody);

        usersViewFooter = new UsersViewFooter(usersViewDataProvider);
        add(usersViewFooter);
    }
}
