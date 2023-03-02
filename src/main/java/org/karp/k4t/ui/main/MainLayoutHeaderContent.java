package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import javax.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;

@CssImport(FOLDER + MainLayoutHeaderContent.CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutHeaderContent extends HorizontalLayout {

    public static final String CLASS_NAME = MainLayoutHeader.CLASS_NAME + "-content";

    private final MainLayoutHeaderContentDrawerToggle drawerToggle;
    private final MainLayoutHeaderContentTitle title;

    public MainLayoutHeaderContent(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setSpacing(false);
        setAlignItems(CENTER);

        drawerToggle = new MainLayoutHeaderContentDrawerToggle(dataProvider);
        add(drawerToggle);

        title = new MainLayoutHeaderContentTitle(dataProvider);
        add(title);
    }

    public void setTitleText(@NotNull String titleText) {
        title.setTitleText(titleText);
    }
}
