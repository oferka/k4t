package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.users.UsersDataProvider;

import java.util.Optional;

import static com.vaadin.flow.component.icon.VaadinIcon.SHARE;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.user.UserView.FOLDER;
import static org.karp.k4t.ui.users.user.UserViewHeaderActionsShareButton.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UserViewHeaderActionsShareButton extends Button {

    public static final String ID = UserViewHeaderActions.ID + "-share-button";

    private final DataProvider dataProvider;
    private long selectedUserId;

    public UserViewHeaderActionsShareButton(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
        addClassName(ID);

        setIcon(SHARE.create());
        setText("Share");
        addClickListener(this::shareClicked);
        addClickShortcut(Key.KEY_S, KeyModifier.ALT);
    }

    private void shareClicked(ClickEvent<Button> event) {
        String name = null;
        Optional<User> user = dataProvider.getUsersDataProvider().findById(selectedUserId);
        if(user.isPresent()) {
            name = user.get().getFirstName();
        }
        Notification.show("Share clicked. Selected user name is: " + name, 3000, MIDDLE);
    }

    public void selectedUserChanged(long selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
}
