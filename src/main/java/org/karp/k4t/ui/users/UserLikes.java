package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static com.vaadin.flow.component.icon.VaadinIcon.HEART_O;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserLikes.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UserLikes extends HorizontalLayout {

    public static final String CLASS_NAME = "user-likes";

    public UserLikes(User user) {
        addClassName(CLASS_NAME);

        Icon likesIcon = HEART_O.create();
        likesIcon.addClassName("user-likes-icon");
        add(likesIcon);
        
        Span likesText = new Span(user.getLikes().toString());
        likesText.addClassName("user-likes-text");
        add(likesText);
    }
}
