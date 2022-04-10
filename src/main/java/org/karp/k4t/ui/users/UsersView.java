package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.main.MainLayout;

import static com.vaadin.flow.component.icon.VaadinIcon.USERS;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;

@Route(value = UsersView.USERS_ROUTE, layout = MainLayout.class)
@PageTitle(UsersView.USERS_VIEW_NAME)
@CssImport(VIEWS_FOLDER + UsersView.USERS_ROUTE + "/" + UsersView.USERS_VIEW_ID + CSS_FILE_EXTENSION)
public class UsersView extends VerticalLayout {

    public static final String USERS_ROUTE = "users";
    public static final String USERS_ID_PREFIX = "users";
    public static final String USERS_ID_SUFFIX = "-view";
    public static final String USERS_VIEW_ID = USERS_ID_PREFIX + USERS_ID_SUFFIX;
    public static final String USERS_VIEW_NAME = "Users";
    public static final VaadinIcon USERS_VIEW_ICON = USERS;

    private final UsersViewHeader usersViewHeader;
    private final UsersViewBody usersViewBody;
    private final UsersViewFooter usersViewFooter;

    public UsersView(UsersDataProvider usersViewDataProvider) {
        setId(USERS_VIEW_ID);
        addClassName(USERS_ID_PREFIX + USERS_ID_SUFFIX);

        setHeightFull();
        setAlignItems(CENTER);

        usersViewHeader = new UsersViewHeader(usersViewDataProvider);
        add(usersViewHeader);

        usersViewBody = new UsersViewBody();
        add(usersViewBody);

        usersViewFooter = new UsersViewFooter();
        add(usersViewFooter);
    }
}
