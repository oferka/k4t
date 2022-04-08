package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_ID_PREFIX;
import static org.karp.k4t.ui.users.UsersView.USERS_VIEW_ICON;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitleIcon.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + USERS_ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitleIcon extends Icon {

    public static final String ID_SUFFIX = "users-view-header-info-title-icon";

    public UsersViewHeaderInfoTitleIcon() {
        super(USERS_VIEW_ICON);
        setSize("60px");
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);
    }
}
