package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitle.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitle extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeaderInfo.CLASS_NAME + "-title";

    private final UsersViewHeaderInfoTitleIcon usersViewHeaderInfoTitleIcon;
    private final UsersViewHeaderInfoTitleText usersViewHeaderInfoTitleType;
    private final UsersViewHeaderInfoTitleCount usersViewHeaderInfoTitleCount;

    public UsersViewHeaderInfoTitle(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setAlignItems(CENTER);

        usersViewHeaderInfoTitleIcon = new UsersViewHeaderInfoTitleIcon(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoTitleIcon);

        usersViewHeaderInfoTitleType = new UsersViewHeaderInfoTitleText(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoTitleType);

        usersViewHeaderInfoTitleCount = new UsersViewHeaderInfoTitleCount(usersViewDataProvider, usersViewState);
        add(usersViewHeaderInfoTitleCount);
    }
}
