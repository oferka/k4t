package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;

import static java.lang.String.format;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitleCount.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitleCount extends H2 {

    public static final String CLASS_NAME = UsersViewHeaderInfoTitle.CLASS_NAME + "-count";

    public UsersViewHeaderInfoTitleCount(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setTitleText(usersViewDataProvider.count());
    }

    public void setTitleText(long count) {
        setText(format("(%s)", count));
    }
}
