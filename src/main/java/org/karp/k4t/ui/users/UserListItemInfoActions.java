package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserListItemInfoActions.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserListItemInfoActions extends HorizontalLayout {

    public static final String ID = "user-list-item-info-actions";

    public UserListItemInfoActions(User user) {
        addClassName(ID);
        setSpacing(false);
        getThemeList().add("spacing-s");

        Icon likesIcon = VaadinIcon.HEART_O.create();
        likesIcon.addClassName("user-card-likes-icon");
        Span likesText = new Span(user.getLikes().toString());
        likesText.addClassName("user-card-likes-text");
        Icon commentsIcon = VaadinIcon.COMMENT_O.create();
        commentsIcon.addClassName("user-card-comments-icon");
        Span commentsText = new Span(user.getComments().toString());
        commentsText.addClassName("user-card-comments-text");
        Icon sharesIcon = VaadinIcon.CONNECT_O.create();
        sharesIcon.addClassName("user-card-shares-icon");
        Span sharesText = new Span(user.getShares().toString());
        sharesText.addClassName("user-card-shares-text");

        add(likesIcon, likesText, commentsIcon, commentsText, sharesIcon, sharesText);
    }
}
