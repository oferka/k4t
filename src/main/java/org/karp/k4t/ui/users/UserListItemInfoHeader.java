package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserListItemInfoHeader.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserListItemInfoHeader extends HorizontalLayout {

    public static final String ID = "user-list-item-info-header";

    private final UserListItemInfoHeaderName userListItemInfoHeaderName;

    public UserListItemInfoHeader(User user) {
        addClassName(ID);
        setSpacing(false);
        getThemeList().add("spacing-s");

        userListItemInfoHeaderName = new UserListItemInfoHeaderName(user);
        add(userListItemInfoHeaderName);

        Span date = new Span(user.getDateOfRegistration().toString());
        date.addClassName("user-card-header-date");
        add(date);
    }
}
