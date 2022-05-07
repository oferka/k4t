package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBodyGridPresentation.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersViewBodyGridPresentation extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewBody.CLASS_NAME + "-grid-presentation";

    private final UsersGrid usersGrid;

    public UsersViewBodyGridPresentation(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);
        setWidthFull();
        setAlignItems(CENTER);
        usersGrid = new UsersGrid(usersDataProvider, usersViewState);
        addAndExpand(usersGrid);
    }
}
