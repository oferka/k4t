package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewFooter.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewFooter extends HorizontalLayout {

    public static final String ID = UsersView.ID + "-footer";

    public UsersViewFooter(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        add(new H2("Users View Footer"));
    }
}
