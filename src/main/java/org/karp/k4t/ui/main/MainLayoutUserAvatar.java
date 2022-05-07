package org.karp.k4t.ui.main;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.dom.DomEvent;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutUserAvatar.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutUserAvatar extends Avatar {

    public static final String CLASS_NAME = MainLayout.ID + "-user-avatar";

    public MainLayoutUserAvatar(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setImage("images/Ofer Karp.png");
        setName("Ofer Karp");
        getElement().addEventListener("click", this::avatarClicked);
    }

    private void avatarClicked(DomEvent event) {
        Notification.show("User avatar clicked", 3000, MIDDLE);
    }
}
