package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBody.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewBody extends VerticalLayout {

    public static final String ID = UsersView.ID + "-body";

    private final UsersViewBodyCardPresentation usersViewBodyCardPresentation;
    private final UsersViewBodyGridPresentation usersViewBodyGridPresentation;

    public UsersViewBody(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        usersViewBodyCardPresentation = new UsersViewBodyCardPresentation(usersDataProvider, usersViewState);
        add(usersViewBodyCardPresentation);

        usersViewBodyGridPresentation = new UsersViewBodyGridPresentation(usersDataProvider, usersViewState);
        add(usersViewBodyGridPresentation);
    }
}
