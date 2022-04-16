package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import org.karp.k4t.model.User;

import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.MEDIUM;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserDateOfRegistration.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserDateOfRegistration extends Span {

    public static final String ID = "user-date-of-registration";

    public UserDateOfRegistration(User user) {
        addClassName(ID);
        setText(user.getDateOfRegistration().format(DateTimeFormatter.ofLocalizedDate(MEDIUM)));
    }
}
