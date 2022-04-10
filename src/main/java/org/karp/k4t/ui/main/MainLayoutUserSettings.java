package org.karp.k4t.ui.main;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.icon.VaadinIcon.COG_O;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.MAIN_FOLDER;
import static org.karp.k4t.ui.main.MainLayoutUserSettings.ID_SUFFIX;

@CssImport(MAIN_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutUserSettings extends Button {

    public static final String ID_SUFFIX = "main-layout-user-settings";

    public MainLayoutUserSettings() {
        setId(ID_SUFFIX);

        Icon settingsIcon = COG_O.create();
        setIcon(settingsIcon);
        addClickListener(this::settingsClicked);
    }

    private void settingsClicked(ClickEvent<Button> event) {
        Notification.show("Settings clicked", 3000, MIDDLE);
    }
}
