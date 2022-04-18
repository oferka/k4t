package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutHeader.ID + CSS_FILE_EXTENSION)
public class HomeLayoutHeader extends HorizontalLayout {

    public static final String ID = HomeLayout.ID + "-header";

    private final HomeLayoutTitle title;
    private final HomeLayoutTabs tabs;

    public HomeLayoutHeader() {
        addClassName(ID);
        setAlignItems(CENTER);

        title = new HomeLayoutTitle();
        add(title);

        tabs = new HomeLayoutTabs();
        add(tabs);
    }

    public void setTitleText(String titleText) {
        title.setTitleText(titleText);
    }

    public void selectTab(Component content) {
        tabs.selectTab(content);
    }
}
