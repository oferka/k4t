package org.karp.k4t.ui.main;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.icon.VaadinIcon.BELL_O;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutUserNotifications.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutUserNotifications extends Button {

    public static final String ID = MainLayout.ID + "-user-notifications";

    public MainLayoutUserNotifications(DataProvider dataProvider) {
        addClassName(ID);
        Icon notificationsIcon = BELL_O.create();
        setIcon(notificationsIcon);
        addClickListener(this::notificationsClicked);
    }

    private void notificationsClicked(ClickEvent<Button> event) {
        Notification.show("Notifications clicked", 3000, MIDDLE);
    }
}
