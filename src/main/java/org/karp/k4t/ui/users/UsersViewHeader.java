package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeader.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeader extends HorizontalLayout {

    public static final String ID = UsersView.ID + "-header";

    private final UsersViewHeaderInfo usersViewHeaderInfo;
    private final UsersViewHeaderActions usersViewHeaderActions;

    public UsersViewHeader(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        setWidthFull();
        setAlignItems(CENTER);

        usersViewHeaderInfo = new UsersViewHeaderInfo(usersViewDataProvider);
        add(usersViewHeaderInfo);

        usersViewHeaderActions = new UsersViewHeaderActions(usersViewDataProvider);
        add(usersViewHeaderActions);
    }
}
