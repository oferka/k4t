package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import org.karp.k4t.model.User;

import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.MEDIUM;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserListItemInfoHeaderDateOfRegistration.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserListItemInfoHeaderDateOfRegistration extends Span {

    public static final String ID = "user-list-item-info-header-date-of-registration";

    public UserListItemInfoHeaderDateOfRegistration(User user) {
        addClassNames(ID);
        setText(user.getDateOfRegistration().format(DateTimeFormatter.ofLocalizedDate(MEDIUM)));
    }
}
