package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutHeader.ID + CSS_FILE_EXTENSION)
public class HomeLayoutHeader extends HorizontalLayout {

    public static final String ID = HomeLayout.ID + "-header";

    private final HomeLayoutTitleBar titleBar;
    private final HomeLayoutTabs tabs;
    private final HomeLayoutSearchBar searchBar;
    private final HomeLayoutActionsBar actionsBar;

    public HomeLayoutHeader(DataProvider dataProvider) {
        addClassName(ID);
        setPadding(true);
        setJustifyContentMode(BETWEEN);

        titleBar = new HomeLayoutTitleBar(dataProvider);
        add(titleBar);

        tabs = new HomeLayoutTabs(dataProvider);
        addAndExpand(tabs);

        searchBar = new HomeLayoutSearchBar(dataProvider);
        add(searchBar);

        actionsBar = new HomeLayoutActionsBar(dataProvider);
        add(actionsBar);

        setVerticalComponentAlignment(CENTER, titleBar, tabs, actionsBar);
    }

    public void selectTab(Component content) {
        tabs.selectTab(content);
    }
}
