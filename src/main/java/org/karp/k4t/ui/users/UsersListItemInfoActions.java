package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersListItemInfoActions.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersListItemInfoActions extends HorizontalLayout {

    public static final String ID = UsersListItemInfo.ID + "-actions";

    private final UserLikes likes;
    private final UserComments comments;
    private final UserShares shares;

    public UsersListItemInfoActions(User user) {
        addClassName(ID);
        setSpacing(false);
        getThemeList().add("spacing-s");

        likes = new UserLikes(user);
        add(likes);

        comments = new UserComments(user);
        add(comments);

        shares = new UserShares(user);
        add(shares);
    }
}
