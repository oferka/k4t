package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfo.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfo extends VerticalLayout {

    public static final String ID= UsersViewHeader.ID + "-info";

    private final UsersViewHeaderInfoTitle usersViewHeaderInfoTitle;
    private final UsersViewHeaderInfoDescription usersViewHeaderInfoDescription;

    public UsersViewHeaderInfo(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        setAlignItems(FlexComponent.Alignment.CENTER);

        usersViewHeaderInfoTitle = new UsersViewHeaderInfoTitle(usersViewDataProvider);
        add(usersViewHeaderInfoTitle);

        usersViewHeaderInfoDescription = new UsersViewHeaderInfoDescription(usersViewDataProvider);
        add(usersViewHeaderInfoDescription);
    }
}
