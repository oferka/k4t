package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoDescription.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoDescription extends Span {

    public static final String ID = UsersViewHeaderInfo.ID + "-description";

    public UsersViewHeaderInfoDescription(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(ID);

        setDescriptionText("Users view description");
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}
