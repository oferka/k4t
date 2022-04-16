package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItemInfoSummary.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersListItemInfoSummary extends Span {

    public static final String ID = UsersListItemInfo.ID + "-summary";

    public UsersListItemInfoSummary(User user) {
        super(user.getSummary());
        addClassName(ID);
    }
}
