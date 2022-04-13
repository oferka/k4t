package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersView.NAME;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoTitleText.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoTitleText extends H2 {

    public static final String ID = UsersViewHeaderInfoTitle.ID + "-text";

    public UsersViewHeaderInfoTitleText(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setTitleText(NAME);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
