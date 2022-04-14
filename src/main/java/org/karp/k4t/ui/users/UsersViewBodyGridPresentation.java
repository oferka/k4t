package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.user.UserView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBodyGridPresentation.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewBodyGridPresentation extends VerticalLayout {

    public static final String ID = UsersViewBody.ID + "-grid-presentation";

    public UsersViewBodyGridPresentation(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        Grid<User> usersGrid = new Grid<>();
        usersGrid.addColumn(User::getId).setHeader("ID");
        usersGrid.addColumn(User::getFirstName).setHeader("First Name");
        usersGrid.addColumn(User::getLastName).setHeader("Last Name");
        usersGrid.addColumn(new ComponentRenderer<>(user -> new RouterLink(user.getId().toString(), UserView.class, user.getId()))).setHeader("Link");
        usersGrid.setItems(usersDataProvider.findAll());
        addAndExpand(usersGrid);
    }
}
