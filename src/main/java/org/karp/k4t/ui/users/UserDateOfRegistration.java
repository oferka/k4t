package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import org.karp.k4t.model.User;

import java.time.format.DateTimeFormatter;

import static java.time.format.FormatStyle.MEDIUM;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserDateOfRegistration.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UserDateOfRegistration extends Span {

    public static final String CLASS_NAME = "user-date-of-registration";

    public UserDateOfRegistration(User user) {
        addClassName(CLASS_NAME);
        setText(user.getDateOfRegistration().format(DateTimeFormatter.ofLocalizedDate(MEDIUM)));
    }
}
