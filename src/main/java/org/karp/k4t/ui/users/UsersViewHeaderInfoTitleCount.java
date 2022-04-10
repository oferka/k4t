package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;

import static java.lang.String.format;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.USERS_FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitleCount.ID_SUFFIX;

@CssImport(USERS_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitleCount extends H2 {

    public static final String ID_SUFFIX = "users-view-header-info-title-count";

    public UsersViewHeaderInfoTitleCount(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setTitleText(usersViewDataProvider.count());
    }

    public void setTitleText(long count) {
        setText(format("(%s)", count));
    }
}
