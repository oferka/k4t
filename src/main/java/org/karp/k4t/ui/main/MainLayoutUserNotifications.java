package org.karp.k4t.ui.main;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.MAIN_FOLDER;
import static org.karp.k4t.ui.main.MainLayoutUserNotifications.ID_SUFFIX;

@CssImport(MAIN_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutUserNotifications extends Button {

    public static final String ID_SUFFIX = "main-layout-user-notifications";

    public MainLayoutUserNotifications() {
        setId(ID_SUFFIX);

        Icon notificationsIcon = VaadinIcon.BELL_O.create();
        setIcon(notificationsIcon);
        addClickListener(this::notificationsClicked);
    }

    private void notificationsClicked(ClickEvent<Button> event) {
        Notification.show("Notifications clicked", 3000, MIDDLE);
    }
}
