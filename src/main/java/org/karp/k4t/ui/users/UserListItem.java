package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.user.UserView;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserListItem.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserListItem extends HorizontalLayout {

    public static final String ID = "user-list-item";

    private final UserListItemAvatar userListItemAvatar;
    private final UserListItemInfo userListItemInfo;

    public UserListItem(User user) {
        addClassName(ID);
        setSpacing(false);
        getThemeList().add("spacing-s");

        userListItemAvatar = new UserListItemAvatar(user);
        add(userListItemAvatar);

        userListItemInfo = new UserListItemInfo(user);
        add(userListItemInfo);
    }
}
