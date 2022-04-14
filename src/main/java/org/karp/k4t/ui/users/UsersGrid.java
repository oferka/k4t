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
        addColumn(User::getId).setHeader("ID");
        addColumn(new ComponentRenderer<>(UserAvatar::new)).setHeader("Picture");
        addColumn(User::getFirstName).setHeader("First Name");
        addColumn(User::getLastName).setHeader("Last Name");
        addColumn(new ComponentRenderer<>(UserRouterLink::new)).setHeader("Link");
        setItems(usersDataProvider.findAll());
    }
}
