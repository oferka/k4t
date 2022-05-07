package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersView.FOLDER;
import static org.karp.k4t.ui.users.UsersViewBody.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UsersViewBody extends VerticalLayout {

    public static final String CLASS_NAME = UsersView.CLASS_NAME + "-body";

    private final UsersViewBodyListPresentation usersViewBodyCardPresentation;
    private final UsersViewBodyGridPresentation usersViewBodyGridPresentation;

    public UsersViewBody(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(CLASS_NAME);

        setWidthFull();
        setAlignItems(CENTER);

        usersViewBodyCardPresentation = new UsersViewBodyListPresentation(usersDataProvider, usersViewState);
        add(usersViewBodyCardPresentation);

        usersViewBodyGridPresentation = new UsersViewBodyGridPresentation(usersDataProvider, usersViewState);
        add(usersViewBodyGridPresentation);

        setPresentationType(usersViewState.getPresentationMode());
        usersViewState.addPresentationModeChangeListener(this::presentationModeChanged);
    }

    private void setPresentationType(UsersViewPresentationMode presentationMode) {
        switch (presentationMode) {
            case GRID:
                remove(usersViewBodyCardPresentation);
                add(usersViewBodyGridPresentation);
                break;
            case LIST:
                remove(usersViewBodyGridPresentation);
                add(usersViewBodyCardPresentation);
                break;
        }
    }

    public void presentationModeChanged(UsersViewPresentationModeChangeEvent event) {
        setPresentationType(event.getNewUserViewPresentationMode());
    }
}
