package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfo.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfo extends VerticalLayout {

    public static final String CLASS_NAME = UsersViewHeader.CLASS_NAME + "-info";

    private final UsersViewHeaderInfoTitle usersViewHeaderInfoTitle;
    private final UsersViewHeaderInfoDescription usersViewHeaderInfoDescription;

    public UsersViewHeaderInfo(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setAlignItems(FlexComponent.Alignment.CENTER);

        usersViewHeaderInfoTitle = new UsersViewHeaderInfoTitle(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoTitle);

        usersViewHeaderInfoDescription = new UsersViewHeaderInfoDescription(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoDescription);
    }
}
