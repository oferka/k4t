package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static com.vaadin.flow.component.icon.VaadinIcon.COMMENT_O;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserComments.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserComments extends HorizontalLayout {

    public static final String ID = "user-comments";

    public UserComments(User user) {
        addClassName(ID);
        Icon commentsIcon = COMMENT_O.create();
        commentsIcon.addClassName("user-card-comments-icon");
        Span commentsText = new Span(user.getComments().toString());
        commentsText.addClassName("user-card-comments-text");
        add(commentsIcon, commentsText);
    }
}
