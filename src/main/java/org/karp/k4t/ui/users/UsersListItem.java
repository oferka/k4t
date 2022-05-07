package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItem.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersListItem extends HorizontalLayout {

    public static final String CLASS_NAME = UsersList.CLASS_NAME + "-item";

    private final UsersListItemAvatar userListItemAvatar;
    private final UsersListItemInfo userListItemInfo;

    public UsersListItem(User user) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        getThemeList().add("spacing-s");

        userListItemAvatar = new UsersListItemAvatar(user);
        add(userListItemAvatar);

        userListItemInfo = new UsersListItemInfo(user);
        add(userListItemInfo);
    }
}
