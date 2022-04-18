package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderMenu.ID + CSS_FILE_EXTENSION)
public class QuizzesMenuBar extends MenuBar {

    public static final String ID = "quizzes-menu-bar";

    public QuizzesMenuBar() {
        addClassName(ID);
        addThemeVariants(MenuBarVariant.LUMO_TERTIARY);
        MenuItem quizzesMenuItem = addItem("Quizzes", e -> quizzesClicked());
    }

    private void quizzesClicked() {
        Notification.show("Quizzes clicked", 3000, MIDDLE);
    }
}
