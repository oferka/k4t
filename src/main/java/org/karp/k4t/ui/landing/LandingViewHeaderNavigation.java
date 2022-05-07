package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.shared.ApplicationImage;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;

@CssImport(FOLDER + LandingViewHeaderNavigation.CLASS_NAME + CSS_FILE_EXTENSION)
public class LandingViewHeaderNavigation extends HorizontalLayout {

    public static final String CLASS_NAME = LandingViewHeader.CLASS_NAME + "-navigation";

    private final ApplicationImage applicationImage;
    private final LandingViewHeaderNavigationTabs navigationTabs;
//    private final HomeMenuBar homeMenuBar;
//    private final SubjectsMenuBar subjectsMenuBar;
//    private final QuestionsMenuBar questionsMenuBar;
//    private final QuizzesMenuBar quizzesMenuBar;
//    private final PlayMenuBar playMenuBar;
//    private final CreateMenuBar createMenuBar;

    public LandingViewHeaderNavigation(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        applicationImage = new ApplicationImage(dataProvider);
        add(applicationImage);

        navigationTabs = new LandingViewHeaderNavigationTabs(dataProvider);
        add(navigationTabs);
    }
}
