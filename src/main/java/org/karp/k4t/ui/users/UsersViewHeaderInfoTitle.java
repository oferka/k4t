package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.USERS_FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitle.ID_SUFFIX;

@CssImport(USERS_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitle extends HorizontalLayout {

    public static final String ID_SUFFIX = "users-view-header-info-title";

    private final UsersViewHeaderInfoTitleIcon usersViewHeaderInfoTitleIcon;
    private final UsersViewHeaderInfoTitleType usersViewHeaderInfoTitleType;
    private final UsersViewHeaderInfoTitleCount usersViewHeaderInfoTitleCount;

    public UsersViewHeaderInfoTitle(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setAlignItems(CENTER);

        usersViewHeaderInfoTitleIcon = new UsersViewHeaderInfoTitleIcon(usersViewDataProvider);
        add(usersViewHeaderInfoTitleIcon);

        usersViewHeaderInfoTitleType = new UsersViewHeaderInfoTitleType(usersViewDataProvider);
        add(usersViewHeaderInfoTitleType);

        usersViewHeaderInfoTitleCount = new UsersViewHeaderInfoTitleCount(usersViewDataProvider);
        add(usersViewHeaderInfoTitleCount);
    }
}
