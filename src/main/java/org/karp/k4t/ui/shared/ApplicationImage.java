package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.Key.KEY_K;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.Application.APPLICATION_LOGO;
import static org.karp.k4t.Application.APPLICATION_NAME;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + ApplicationImage.ID + CSS_FILE_EXTENSION)
public class ApplicationImage extends Image {

    public static final String ID = "application-image";

    public ApplicationImage() {
        addClassName(ID);
        setSrc(APPLICATION_LOGO);
        setAlt(APPLICATION_NAME);
        addClickListener(this::applicationImageClicked);
        addClickShortcut(KEY_K, ALT);
    }

    private void applicationImageClicked(ClickEvent<Image> event) {
        Notification.show("Application Image Clicked", 3000, MIDDLE);
    }
}
