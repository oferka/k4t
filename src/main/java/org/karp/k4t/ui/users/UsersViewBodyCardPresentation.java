package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBodyCardPresentation.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewBodyCardPresentation extends VerticalLayout {

    public static final String ID = UsersViewBody.ID + "-card-presentation";

    private final UsersCards usersCards;

    public UsersViewBodyCardPresentation(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(ID);
        setWidthFull();
        setAlignItems(CENTER);
        usersCards = new UsersCards(usersDataProvider, usersViewState);
        addAndExpand(usersCards);
    }
}
