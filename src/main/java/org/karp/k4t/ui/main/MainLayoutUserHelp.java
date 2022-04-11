package org.karp.k4t.ui.main;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.icon.VaadinIcon.QUESTION_CIRCLE_O;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.MAIN_FOLDER;
import static org.karp.k4t.ui.main.MainLayoutUserHelp.ID;

@CssImport(MAIN_FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutUserHelp extends Button {

    public static final String ID = MainLayout.ID + "-user-help";

    public MainLayoutUserHelp() {
        addClassName(ID);

        Icon helpIcon = QUESTION_CIRCLE_O.create();
        setIcon(helpIcon);
        addClickListener(this::helpClicked);
    }

    private void helpClicked(ClickEvent<Button> event) {
        Notification.show("Help clicked", 3000, MIDDLE);
    }
}
