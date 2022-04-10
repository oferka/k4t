package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_ID_PREFIX;
import static org.karp.k4t.ui.users.UsersViewHeader.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + USERS_ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeader extends HorizontalLayout {

    public static final String ID_SUFFIX = "users-view-header";

    private final UsersViewHeaderInfo usersViewHeaderInfo;
    private final UsersViewHeaderActions usersViewHeaderActions;

    public UsersViewHeader(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setWidthFull();
        setAlignItems(CENTER);

        usersViewHeaderInfo = new UsersViewHeaderInfo(usersViewDataProvider);
        add(usersViewHeaderInfo);

        usersViewHeaderActions = new UsersViewHeaderActions();
        add(usersViewHeaderActions);
    }
}
