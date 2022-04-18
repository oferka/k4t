package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import org.karp.k4t.ui.questions.QuestionsView;
import org.karp.k4t.ui.quizzes.QuizzesView;

import java.util.Optional;

import static com.vaadin.flow.component.tabs.Tabs.Orientation.HORIZONTAL;
import static com.vaadin.flow.component.tabs.TabsVariant.LUMO_MINIMAL;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTabs.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTabs extends Tabs {

    public static final String ID = HomeLayout.ID + "-tabs";

    public HomeLayoutTabs() {
        addClassName(ID);
        setOrientation(HORIZONTAL);
        addThemeVariants(LUMO_MINIMAL);
        add(createTabs());
    }

    private Component[] createTabs() {
        return new Component[] {
                new HomeLayoutTab(HomeView.NAME, HomeView.class, HomeView.ICON),
                new HomeLayoutTab(QuestionsView.NAME, QuestionsView.class, QuestionsView.ICON),
                new HomeLayoutTab(QuizzesView.NAME, QuizzesView.class, QuizzesView.ICON)
        };
    }

    public void selectTab(Component content) {
        getTabForComponent(content).ifPresent(this::setSelectedTab);
    }

    private Optional<Tab> getTabForComponent(Component content) {
        return getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(content.getClass())).findFirst().map(Tab.class::cast);
    }
}
