package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.menubar.MenuBarVariant.LUMO_PRIMARY;
import static com.vaadin.flow.component.menubar.MenuBarVariant.LUMO_SMALL;
import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderNavigation.CLASS_NAME + CSS_FILE_EXTENSION)
public class PlayMenuBar extends MenuBar {

    public static final String CLASS_NAME = "play-menu-bar";

    public PlayMenuBar() {
        addClassName(CLASS_NAME);
        addThemeVariants(LUMO_SMALL, LUMO_PRIMARY);

        MenuItem playMenuItem = addItem("Play");
        SubMenu playSubMenu = playMenuItem.getSubMenu();
        MenuItem playQuestions = playSubMenu.addItem("Play Questions", e -> playQuestionsClicked());
        MenuItem playQuizzes = playSubMenu.addItem("Play Quizzes", e -> playQuizzesClicked());
    }

    private void playQuestionsClicked() {
        Notification.show("Play questions clicked", 3000, MIDDLE);
    }

    private void playQuizzesClicked() {
        Notification.show("Play quizzes clicked", 3000, MIDDLE);
    }
}
