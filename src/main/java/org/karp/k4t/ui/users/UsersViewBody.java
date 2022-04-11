package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.user.UserView;

import java.util.List;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBody.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewBody extends VerticalLayout {

    public static final String ID = UsersView.ID + "-body";

    public UsersViewBody(UsersDataProvider usersDataProvider) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        List<User> users = usersDataProvider.findAll();
        for(User user : users) {
            add(new RouterLink(user.getId().toString(), UserView.class, user.getId().toString()));
        }
    }
}
