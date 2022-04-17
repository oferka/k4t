package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersGrid.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersGrid extends Grid<User> {

    public static final String ID = "users-grid";

    public UsersGrid(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(ID);
        setWidthFull();
        addColumn(User::getId).setHeader("ID").setSortable(true);
        addColumn(new ComponentRenderer<>(UserAvatar::new)).setHeader("Picture").setComparator(User::getFirstName);
        addColumn(User::getFirstName).setHeader("First Name").setSortable(true);
        addColumn(User::getLastName).setHeader("Last Name").setSortable(true);
        addColumn(new ComponentRenderer<>(UserRouterLink::new)).setHeader("Link").setComparator(User::getFirstName);
        addColumn(new ComponentRenderer<>(UserDateOfRegistration::new)).setHeader("Registered").setComparator(User::getDateOfRegistration);
        addColumn(new ComponentRenderer<>(UserLikes::new)).setHeader("Likes").setComparator(User::getLikes);
        addColumn(new ComponentRenderer<>(UserComments::new)).setHeader("Comments").setComparator(User::getComments);
        addColumn(new ComponentRenderer<>(UserShares::new)).setHeader("Shares").setComparator(User::getShares);
        setItems(usersDataProvider.findAll());
    }
}
