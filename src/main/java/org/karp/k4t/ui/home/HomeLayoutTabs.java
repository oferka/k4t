package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.questions.QuestionsView;
import org.karp.k4t.ui.quizzes.QuizzesView;

import java.util.Optional;

import static com.vaadin.flow.component.tabs.Tabs.Orientation.HORIZONTAL;
import static com.vaadin.flow.component.tabs.TabsVariant.LUMO_CENTERED;
import static com.vaadin.flow.component.tabs.TabsVariant.LUMO_MINIMAL;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@Slf4j
@CssImport(FOLDER + HomeLayoutTabs.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTabs extends Tabs {

    public static final String ID = HomeLayout.ID + "-tabs";

    public HomeLayoutTabs(DataProvider dataProvider) {
        addClassName(ID);
        setOrientation(HORIZONTAL);
        addThemeVariants(LUMO_CENTERED, LUMO_MINIMAL);
        add(createTabs(dataProvider));
    }

    private Component[] createTabs(DataProvider dataProvider) {
        return new Component[] {
                new HomeLayoutTab(dataProvider, HomeView.NAME, HomeView.class),
                new HomeLayoutTab(dataProvider, QuestionsView.NAME, QuestionsView.class),
                new HomeLayoutTab(dataProvider, QuizzesView.NAME, QuizzesView.class)
        };
    }

    public void presentTab(Component content) {
        getTabForComponent(content).ifPresent(this::setSelectedTab);
        log.info("Present tab: {}", ((HomeLayoutTab)getSelectedTab()).getText());
    }

    private Optional<Tab> getTabForComponent(Component content) {
        return getChildren().filter(tab -> ComponentUtil.getData(tab, Class.class).equals(content.getClass())).findFirst().map(Tab.class::cast);
    }
}
