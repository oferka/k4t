package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.user.UserView;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBodyGridPresentationGrid.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewBodyGridPresentationGrid extends Grid<User> {

    public static final String ID = UsersViewBodyGridPresentation.ID + "-grid";

    public UsersViewBodyGridPresentationGrid(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setWidthFull();
        addColumn(User::getId).setHeader("ID");
        addColumn(User::getFirstName).setHeader("First Name");
        addColumn(User::getLastName).setHeader("Last Name");
        addColumn(new ComponentRenderer<>(user -> new RouterLink(user.getId().toString(), UserView.class, user.getId()))).setHeader("Link");
        setItems(usersDataProvider.findAll());
    }
}
