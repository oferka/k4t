package org.karp.k4t.ui.users;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsPresentationTypeSelector.ID;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsPresentationTypeSelector.PresentationType.CARD;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsPresentationTypeSelector.PresentationType.GRID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String ID = UsersViewHeaderActions.ID + "-presentation-type-selector";

    private final UsersViewHeaderActionsTypeSelectorGridButton usersViewHeaderActionsTypeSelectorGridButton;
    private final UsersViewHeaderActionsTypeSelectorCardButton usersViewHeaderActionsTypeSelectorCardButton;

    public UsersViewHeaderActionsPresentationTypeSelector(UsersDataProvider usersViewDataProvider) {
        addClassName(ID);

        setSpacing(false);

        usersViewHeaderActionsTypeSelectorGridButton = new UsersViewHeaderActionsTypeSelectorGridButton(usersViewDataProvider);
        usersViewHeaderActionsTypeSelectorGridButton.addClickListener(this::gridPresentationTypeClicked);
        add(usersViewHeaderActionsTypeSelectorGridButton);

        usersViewHeaderActionsTypeSelectorCardButton = new UsersViewHeaderActionsTypeSelectorCardButton(usersViewDataProvider);
        usersViewHeaderActionsTypeSelectorCardButton.addClickListener(this::cardPresentationTypeClicked);
        add(usersViewHeaderActionsTypeSelectorCardButton);

        setSelectedPresentationType(GRID);
    }

    private void gridPresentationTypeClicked(ClickEvent<Button> event) {
        setSelectedPresentationType(GRID);
    }

    private void cardPresentationTypeClicked(ClickEvent<Button> event) {
        setSelectedPresentationType(CARD);
    }

    private void setSelectedPresentationType(PresentationType selectedPresentationType) {
        switch (selectedPresentationType) {
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

    public enum PresentationType {
        GRID,
        CARD;
    }
}
