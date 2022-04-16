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
import static org.karp.k4t.ui.users.UserListItemInfo.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserListItemInfo extends VerticalLayout {

    public static final String ID = "user-list-item-info";

    public UserListItemInfo(User user) {
        addClassName(ID);
        setSpacing(false);
        setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("user-card-header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        RouterLink name = new RouterLink(user.getFirstName() + " " + user.getLastName(), UserView.class, user.getId());
        name.addClassName("user-card-header-name");
        Span date = new Span(user.getDateOfRegistration().toString());
        date.addClassName("user-card-header-date");
        header.add(name, date);

        Span summary = new Span(user.getSummary());
        summary.addClassName("user-card-header-summary");

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("user-card-actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

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

        actions.add(likesIcon, likesText, commentsIcon, commentsText, sharesIcon, sharesText);

        add(header, summary, actions);
    }
}
