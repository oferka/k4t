package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.USERS_FOLDER;
import static org.karp.k4t.ui.users.UsersViewFooter.ID_SUFFIX;

@CssImport(USERS_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewFooter extends HorizontalLayout {

    public static final String ID_SUFFIX = "users-view-footer";

    public UsersViewFooter(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setWidthFull();
        setAlignItems(CENTER);

        add(new H1("Users View Footer"));
    }
}
