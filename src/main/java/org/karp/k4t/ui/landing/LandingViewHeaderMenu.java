package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.shared.ApplicationImage;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderMenu.ID + CSS_FILE_EXTENSION)
public class LandingViewHeaderMenu extends HorizontalLayout {

    public static final String ID = LandingViewHeader.ID + "-menu";

    private final ApplicationImage applicationImage;
    private final HomeMenuBar homeMenuBar;
    private final SubjectsMenuBar subjectsMenuBar;
    private final QuestionsMenuBar questionsMenuBar;
    private final QuizzesMenuBar quizzesMenuBar;
    private final PlayMenuBar playMenuBar;
    private final CreateMenuBar createMenuBar;

    public LandingViewHeaderMenu() {
        addClassName(ID);
        setAlignItems(CENTER);

        applicationImage = new ApplicationImage();
        homeMenuBar = new HomeMenuBar();
        subjectsMenuBar = new SubjectsMenuBar();
        questionsMenuBar = new QuestionsMenuBar();
        quizzesMenuBar = new QuizzesMenuBar();
        playMenuBar = new PlayMenuBar();
        createMenuBar = new CreateMenuBar();

        add(applicationImage, homeMenuBar, subjectsMenuBar, questionsMenuBar, quizzesMenuBar, playMenuBar, createMenuBar);
    }
}
