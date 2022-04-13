package org.karp.k4t.ui.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UserViewPresentationMode.CARD;
import static org.karp.k4t.ui.users.UserViewPresentationMode.GRID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsPresentationTypeSelector.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String ID = UsersViewHeaderActions.ID + "-presentation-type-selector";

    private final UsersViewHeaderActionsTypeSelectorGridButton usersViewHeaderActionsTypeSelectorGridButton;
    private final UsersViewHeaderActionsTypeSelectorCardButton usersViewHeaderActionsTypeSelectorCardButton;

    private final UsersViewState usersViewState;

    public UsersViewHeaderActionsPresentationTypeSelector(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        this.usersViewState = usersViewState;
        addClassName(ID);

        setSpacing(false);

        usersViewHeaderActionsTypeSelectorGridButton = new UsersViewHeaderActionsTypeSelectorGridButton(usersViewDataProvider, usersViewState);
        usersViewHeaderActionsTypeSelectorGridButton.addClickListener(this::gridPresentationTypeClicked);
        add(usersViewHeaderActionsTypeSelectorGridButton);

        usersViewHeaderActionsTypeSelectorCardButton = new UsersViewHeaderActionsTypeSelectorCardButton(usersViewDataProvider, usersViewState);
        usersViewHeaderActionsTypeSelectorCardButton.addClickListener(this::cardPresentationTypeClicked);
        add(usersViewHeaderActionsTypeSelectorCardButton);

        setPresentationType(usersViewState.getPresentationMode());
    }

    private void gridPresentationTypeClicked(ClickEvent<Button> event) {
        setPresentationType(GRID);
        usersViewState.setPresentationMode(GRID);
    }

    private void cardPresentationTypeClicked(ClickEvent<Button> event) {
        setPresentationType(CARD);
        usersViewState.setPresentationMode(CARD);
    }

    private void setPresentationType(UserViewPresentationMode userViewPresentationType) {
        switch (userViewPresentationType) {
            case GRID:
                usersViewHeaderActionsTypeSelectorGridButton.setEnabled(false);
                usersViewHeaderActionsTypeSelectorCardButton.setEnabled(true);
                break;
            case CARD:
                usersViewHeaderActionsTypeSelectorGridButton.setEnabled(true);
                usersViewHeaderActionsTypeSelectorCardButton.setEnabled(false);
                break;
        }
    }
}
