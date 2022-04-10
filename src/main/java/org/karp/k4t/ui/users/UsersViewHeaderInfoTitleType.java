package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.USERS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_VIEW_NAME;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitleType.ID_SUFFIX;

@CssImport(USERS_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitleType extends H2 {

    public static final String ID_SUFFIX = "users-view-header-info-title-type";

    public UsersViewHeaderInfoTitleType(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setTitleText(USERS_VIEW_NAME);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
