package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.USERS_FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfo.ID_SUFFIX;

@CssImport(USERS_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfo extends VerticalLayout {

    public static final String ID_SUFFIX = "users-view-header-info";

    private final UsersViewHeaderInfoTitle usersViewHeaderInfoTitle;
    private final UsersViewHeaderInfoDescription usersViewHeaderInfoDescription;

    public UsersViewHeaderInfo(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setAlignItems(FlexComponent.Alignment.CENTER);

        usersViewHeaderInfoTitle = new UsersViewHeaderInfoTitle(usersViewDataProvider);
        add(usersViewHeaderInfoTitle);

        usersViewHeaderInfoDescription = new UsersViewHeaderInfoDescription(usersViewDataProvider);
        add(usersViewHeaderInfoDescription);
    }
}
