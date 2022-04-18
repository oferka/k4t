package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.menubar.MenuBarVariant.LUMO_SMALL;
import static com.vaadin.flow.component.menubar.MenuBarVariant.LUMO_TERTIARY;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderNavigation.ID + CSS_FILE_EXTENSION)
public class QuestionsMenuBar extends MenuBar {

    public static final String ID = "questions-menu-bar";

    public QuestionsMenuBar() {
        addClassName(ID);
        addThemeVariants(LUMO_SMALL, LUMO_TERTIARY);
        MenuItem questionsMenuItem = addItem("Questions", e -> questionsClicked());
    }

    private void questionsClicked() {
        Notification.show("Questions clicked", 3000, MIDDLE);
    }
}
