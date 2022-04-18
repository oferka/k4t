package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.notification.Notification;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderMenuBar.ID + CSS_FILE_EXTENSION)
public class LandingViewHeaderMenuBar extends MenuBar {

    public static final String ID = LandingViewHeaderMenu.ID + "-bar";

    public LandingViewHeaderMenuBar() {
        addClassName(LandingViewHeaderMenuBar.ID);

        addThemeVariants(MenuBarVariant.LUMO_TERTIARY);

        MenuItem logoMenuItem = addItem("Logo", e -> logoClicked());

        MenuItem homeMenuItem = addItem("Home", e -> homeClicked());

        MenuItem topicsMenuItem = addItem("Topics", e -> topicsClicked());

        MenuItem questionsMenuItem = addItem("Questions", e -> questionsClicked());

        MenuItem quizzesMenuItem = addItem("Quizzes", e -> quizzesClicked());

        MenuItem createMenuItem = addItem("Create");
        SubMenu createSubMenu = createMenuItem.getSubMenu();
        MenuItem createTopics = createSubMenu.addItem("Create Topics", e -> createTopicsClicked());
        MenuItem createQuestions = createSubMenu.addItem("Create Questions", e -> createQuestionsClicked());
        MenuItem createQuizzes = createSubMenu.addItem("Create Quizzes", e -> createQuizzesClicked());

        MenuItem playMenuItem = addItem("Play");
        SubMenu playSubMenu = playMenuItem.getSubMenu();
        MenuItem playQuestions = playSubMenu.addItem("Answer Questions", e -> playQuestionsClicked());
        MenuItem playQuizzes = playSubMenu.addItem("Answer Quizzes", e -> playQuizzesClicked());
    }

    private void logoClicked() {
        Notification.show("Logo clicked", 3000, MIDDLE);
    }

    private void homeClicked() {
        Notification.show("Home clicked", 3000, MIDDLE);
    }

    private void topicsClicked() {
        Notification.show("Topics clicked", 3000, MIDDLE);
    }

    private void questionsClicked() {
        Notification.show("Questions clicked", 3000, MIDDLE);
    }

    private void quizzesClicked() {
        Notification.show("Quizzes clicked", 3000, MIDDLE);
    }

    private void createClicked() {
        Notification.show("Create clicked", 3000, MIDDLE);
    }

    private void playClicked() {
        Notification.show("Play clicked", 3000, MIDDLE);
    }

    private void playQuestionsClicked() {
        Notification.show("Play questions clicked", 3000, MIDDLE);
    }

    private void playQuizzesClicked() {
        Notification.show("Play quizzes clicked", 3000, MIDDLE);
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
