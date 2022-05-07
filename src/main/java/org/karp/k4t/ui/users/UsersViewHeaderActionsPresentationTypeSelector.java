package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewHeaderActionsPresentationTypeSelector.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersViewHeaderActionsPresentationTypeSelector extends HorizontalLayout {

    public static final String CLASS_NAME = UsersViewHeaderActions.CLASS_NAME + "-presentation-type-selector";

    private final UsersViewHeaderActionsTypeSelectorGridButton gridButton;
    private final UsersViewHeaderActionsTypeSelectorListButton listButton;

    public UsersViewHeaderActionsPresentationTypeSelector(UsersDataProvider usersViewDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setSpacing(false);

        gridButton = new UsersViewHeaderActionsTypeSelectorGridButton(usersViewDataProvider, usersViewState);
        add(gridButton);

        listButton = new UsersViewHeaderActionsTypeSelectorListButton(usersViewDataProvider, usersViewState);
        add(listButton);

        setPresentationType(usersViewState.getPresentationMode());
        usersViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(UsersViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID:
                gridButton.setEnabled(false);
                listButton.setEnabled(true);
                break;
            case LIST:
                gridButton.setEnabled(true);
                listButton.setEnabled(false);
                break;
        }
    }

    public void presentationModeChanged(UsersViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewUserViewPresentationMode());
    }
}
