package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersView.ICON;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitleIcon.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitleIcon extends Icon {

    public static final String CLASS_NAME = UsersViewHeaderInfoTitle.CLASS_NAME + "-icon";

    public UsersViewHeaderInfoTitleIcon(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        super(ICON);
        setSize("60px");
        addClassName(CLASS_NAME);
    }
}
