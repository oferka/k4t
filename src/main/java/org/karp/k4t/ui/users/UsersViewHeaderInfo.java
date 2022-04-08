package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_ID_PREFIX;
import static org.karp.k4t.ui.users.UsersViewHeaderInfo.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + USERS_ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfo extends VerticalLayout {

    public static final String ID_SUFFIX = "users-view-header-info";

    private final UsersViewHeaderInfoTitle usersViewHeaderInfoTitle;
    private final UsersViewHeaderInfoDescription usersViewHeaderInfoDescription;

    public UsersViewHeaderInfo() {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setAlignItems(FlexComponent.Alignment.CENTER);

        usersViewHeaderInfoTitle = new UsersViewHeaderInfoTitle();
        add(usersViewHeaderInfoTitle);

        usersViewHeaderInfoDescription = new UsersViewHeaderInfoDescription();
        add(usersViewHeaderInfoDescription);
    }
}
