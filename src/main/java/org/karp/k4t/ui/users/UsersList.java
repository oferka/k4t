package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.model.User;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersList.CLASS_NAME;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersList extends Div {

    public static final String CLASS_NAME = "users-list";

    public UsersList(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);
        setWidthFull();
        Grid<User> grid = new Grid<>();
        grid.addClassName("users-list-grid");
        setSizeFull();
        grid.setHeightFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(this::createListItem);
        grid.setItems(usersDataProvider.findAll());
        add(grid);
    }

    private HorizontalLayout createListItem(User user) {
        return new UsersListItem(user);
    }
}
