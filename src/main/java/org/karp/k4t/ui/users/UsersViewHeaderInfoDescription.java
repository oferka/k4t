package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.USERS_FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderInfoDescription.ID_SUFFIX;

@CssImport(USERS_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class UsersViewHeaderInfoDescription extends Span {

    public static final String ID_SUFFIX = "users-view-header-info-description";

    public UsersViewHeaderInfoDescription(UsersDataProvider usersViewDataProvider) {
        setId(ID_SUFFIX);
        addClassName(ID_SUFFIX);

        setDescriptionText("Users view description");
    }

    public void setDescriptionText(@NotNull String descriptionText) {
        setText(descriptionText);
    }
}