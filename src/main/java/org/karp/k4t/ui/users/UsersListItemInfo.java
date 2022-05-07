package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItemInfo.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersListItemInfo extends VerticalLayout {

    public static final String CLASS_NAME = UsersListItem.CLASS_NAME + "-info";

    private final UsersListItemInfoHeader header;
    private final UsersListItemInfoSummary summary;
    private final UsersListItemInfoActions actions;

    public UsersListItemInfo(User user) {
        addClassName(CLASS_NAME);
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
