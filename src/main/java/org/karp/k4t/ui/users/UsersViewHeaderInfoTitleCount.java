package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;

import static java.lang.String.format;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_ID_PREFIX;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitleCount.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + USERS_ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitleCount extends H2 {

    public static final String ID_SUFFIX = "users-view-header-info-title-count";

    public UsersViewHeaderInfoTitleCount() {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

//        setTitleText(usersDataProvider.count());
        setTitleText(91);
    }

    public void setTitleText(long count) {
        setText(format("(%s)", count));
    }
}
