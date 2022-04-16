package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItemInfo.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersListItemInfo extends VerticalLayout {

    public static final String ID = UsersListItem.ID + "-info";

    private final UsersListItemInfoHeader header;
    private final UsersListItemInfoSummary summary;
    private final UsersListItemInfoActions actions;

    public UsersListItemInfo(User user) {
        addClassName(ID);
        setSpacing(false);
        setPadding(false);

        header = new UsersListItemInfoHeader(user);
        add(header);

        summary = new UsersListItemInfoSummary(user);
        add(summary);

        actions = new UsersListItemInfoActions(user);
        add(actions);
    }
}
