package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.UsersDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.SHARE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderActionsShareButton.ID;

@CssImport(USER_FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewHeaderActionsShareButton extends Button {

    public static final String ID = UserViewHeaderActions.ID + "-share-button";

    private final UsersDataProvider usersDataProvider;
    private long selectedUserId;

    public UserViewHeaderActionsShareButton(UsersDataProvider usersDataProvider) {
        this.usersDataProvider = usersDataProvider;
        addClassName(ID);

        setIcon(SHARE.create());
        setText("Share");
        addClickListener(this::shareClicked);
        addClickShortcut(Key.KEY_S, KeyModifier.ALT);
    }

    private void shareClicked(ClickEvent<Button> event) {
        String firstName = null;
        Optional<User> user = usersDataProvider.findById(selectedUserId);
        if(user.isPresent()) {
            firstName = user.get().getFirstName();
        }
        Notification.show("Share clicked. Selected user first name is: " + firstName, 3000, MIDDLE);
    }

    public void selectedUserChanged(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
}
