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
import static org.karp.k4t.ui.users.UsersView.CLASS_NAME;

@Route(value = UsersView.ROUTE, layout = MainLayout.class)
@PageTitle(UsersView.NAME)
@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersView extends VerticalLayout {

    public static final String ROUTE = "users";
    public static final String ID_PREFIX = "users";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Users";
    public static final VaadinIcon ICON = USERS;

    private final UsersViewHeader header;
    private final UsersViewBody body;
    private final UsersViewFooter footer;

    public UsersView(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        header = new UsersViewHeader(usersViewDataProvider, usersViewState);
        add(header);

        body = new UsersViewBody(usersViewDataProvider, usersViewState);
        addAndExpand(body);

        footer = new UsersViewFooter(usersViewDataProvider, usersViewState);
        add(footer);
    }
}
