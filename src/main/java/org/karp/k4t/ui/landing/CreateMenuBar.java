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

@CssImport(FOLDER + LandingViewHeaderNavigation.ID + CSS_FILE_EXTENSION)
public class CreateMenuBar extends MenuBar {

    public static final String ID = "create-menu-bar";

    public CreateMenuBar() {
        addClassName(ID);
        addThemeVariants(LUMO_SMALL, LUMO_PRIMARY);

        MenuItem createMenuItem = addItem("Create");
        SubMenu createSubMenu = createMenuItem.getSubMenu();
        MenuItem createTopics = createSubMenu.addItem("Create Topics", e -> createTopicsClicked());
        MenuItem createQuestions = createSubMenu.addItem("Create Questions", e -> createQuestionsClicked());
        MenuItem createQuizzes = createSubMenu.addItem("Create Quizzes", e -> createQuizzesClicked());
    }

    private void createTopicsClicked() {
        Notification.show("Create topics clicked", 3000, MIDDLE);
    }

    private void createQuestionsClicked() {
        Notification.show("Create questions clicked", 3000, MIDDLE);
    }

    private void createQuizzesClicked() {
        Notification.show("Create quizzes clicked", 3000, MIDDLE);
    }
}
