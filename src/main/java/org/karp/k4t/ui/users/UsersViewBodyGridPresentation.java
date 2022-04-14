package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBodyGridPresentation.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewBodyGridPresentation extends VerticalLayout {

    public static final String ID = UsersViewBody.ID + "-grid-presentation";

    private final UsersGrid usersViewBodyGridPresentationGrid;

    public UsersViewBodyGridPresentation(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        usersViewBodyGridPresentationGrid = new UsersGrid(usersDataProvider, usersViewState);
        addAndExpand(usersViewBodyGridPresentationGrid);
    }
}
