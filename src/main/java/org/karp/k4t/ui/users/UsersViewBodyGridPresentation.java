package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.user.UserView;

import java.util.List;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBodyGridPresentation.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewBodyGridPresentation extends VerticalLayout {

    public static final String ID = UsersViewBody.ID + "-grid-presentation";

    public UsersViewBodyGridPresentation(UsersDataProvider usersDataProvider) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        add(new H3("Grid Presentation"));

        List<User> users = usersDataProvider.findAll();
        for(User user : users) {
            add(new RouterLink(user.getId().toString(), UserView.class, user.getId().toString()));
        }
    }
}
