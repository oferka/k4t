package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.DataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.button.ButtonVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderActionsExportButton.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class UserViewHeaderActionsExportButton extends Button {

    public static final String CLASS_NAME = UserViewHeaderActions.CLASS_NAME + "-export-button";

    private final DataProvider dataProvider;
    private long selectedUserId;

    public UserViewHeaderActionsExportButton(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        addClassName(CLASS_NAME);

        setIcon(VaadinIcon.DOWNLOAD.create());
        setText("Export");
        addThemeVariants(LUMO_PRIMARY);
        addClickListener(this::exportClicked);
        addClickShortcut(Key.KEY_E, KeyModifier.ALT);
    }

    private void exportClicked(ClickEvent<Button> event) {
        String name = null;
        Optional<User> user = dataProvider.getUsersDataProvider().findById(selectedUserId);
        if(user.isPresent()) {
            name = user.get().getFirstName();
        }
        Notification.show("Export clicked. Selected user name is: " + name, 3000, MIDDLE);
    }

    public void selectedUserChanged(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
}
