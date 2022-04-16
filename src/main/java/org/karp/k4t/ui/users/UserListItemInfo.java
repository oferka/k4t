package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserListItemInfo.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserListItemInfo extends VerticalLayout {

    public static final String ID = "user-list-item-info";

    private final UserListItemInfoHeader header;
    private final UserListItemInfoSummary summary;
    private final UserListItemInfoActions actions;

    public UserListItemInfo(User user) {
        addClassName(ID);
        setSpacing(false);
        setPadding(false);

        header = new UserListItemInfoHeader(user);
        add(header);

        summary = new UserListItemInfoSummary(user);
        add(summary);

        actions = new UserListItemInfoActions(user);
        add(actions);
    }
}
