package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderMenu.ID + CSS_FILE_EXTENSION)
public class LandingViewHeaderMenu extends Div {

    public static final String ID = LandingViewHeader.ID + "-menu";

    private final LogoMenuBar logoMenuBar;
    private final HomeMenuBar homeMenuBar;
    private final SubjectsMenuBar subjectsMenuBar;
    private final QuestionsMenuBar questionsMenuBar;
    private final QuizzesMenuBar quizzesMenuBar;
    private final PlayMenuBar playMenuBar;
    private final CreateMenuBar createMenuBar;

    public LandingViewHeaderMenu() {
        addClassName(ID);

        logoMenuBar = new LogoMenuBar();
        homeMenuBar = new HomeMenuBar();
        subjectsMenuBar = new SubjectsMenuBar();
        questionsMenuBar = new QuestionsMenuBar();
        quizzesMenuBar = new QuizzesMenuBar();
        playMenuBar = new PlayMenuBar();
        createMenuBar = new CreateMenuBar();

        setInlineBlock(logoMenuBar);
        setInlineBlock(homeMenuBar);
        setInlineBlock(subjectsMenuBar);
        setInlineBlock(questionsMenuBar);
        setInlineBlock(quizzesMenuBar);
        setInlineBlock(playMenuBar);
        setInlineBlock(createMenuBar);

        add(logoMenuBar, homeMenuBar, subjectsMenuBar, questionsMenuBar, quizzesMenuBar, playMenuBar, createMenuBar);
    }

    private void setInlineBlock(MenuBar menuBar) {
        menuBar.getStyle().set("display", "inline-block");
    }
}
