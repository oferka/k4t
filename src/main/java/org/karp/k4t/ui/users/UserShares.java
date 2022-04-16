package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static com.vaadin.flow.component.icon.VaadinIcon.CONNECT_O;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserShares.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserShares extends HorizontalLayout {

    public static final String ID = "user-shares";

    public UserShares(User user) {
        addClassName(ID);

        Icon sharesIcon = CONNECT_O.create();
        sharesIcon.addClassName("user-shares-icon");
        add(sharesIcon);

        Span sharesText = new Span(user.getShares().toString());
        sharesText.addClassName("user-shares-text");
        add(sharesText);
    }
}
