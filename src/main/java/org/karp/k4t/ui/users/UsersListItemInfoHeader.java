package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItemInfoHeader.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersListItemInfoHeader extends HorizontalLayout {

    public static final String CLASS_NAME = UsersListItemInfo.CLASS_NAME + "-header";

    private final UsersListItemInfoHeaderName name;
    private final UsersListItemInfoHeaderDateOfRegistration dateOfRegistration;

    public UsersListItemInfoHeader(User user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        name = new UsersListItemInfoHeaderName(user);
        add(name);

        dateOfRegistration = new UsersListItemInfoHeaderDateOfRegistration(user);
        add(dateOfRegistration);
    }
}
