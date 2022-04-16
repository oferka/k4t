package org.karp.k4t.ui.main;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.dom.DomEvent;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutUserAvatar.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutUserAvatar extends Avatar {

    public static final String ID = MainLayout.ID + "-user-avatar";

    public MainLayoutUserAvatar() {
        addClassName(ID);
        setImage("images/Ofer Karp.png");
        setName("Ofer Karp");
        getElement().addEventListener("click", this::avatarClicked);
    }

    private void avatarClicked(DomEvent event) {
        Notification.show("User avatar clicked", 3000, MIDDLE);
    }
}
