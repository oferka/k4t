package org.karp.k4t.ui.main;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.icon.VaadinIcon.QUESTION_CIRCLE_O;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutUserHelp.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutUserHelp extends Button {

    public static final String CLASS_NAME = MainLayout.ID + "-user-help";

    public MainLayoutUserHelp(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        Icon helpIcon = QUESTION_CIRCLE_O.create();
        setIcon(helpIcon);
        addClickListener(this::helpClicked);
    }

    private void helpClicked(ClickEvent<Button> event) {
        Notification.show("Help clicked", 3000, MIDDLE);
    }
}
