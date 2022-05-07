package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTitleBar.CLASS_NAME + CSS_FILE_EXTENSION)
public class HomeLayoutTitleBar extends HorizontalLayout {

    public static final String CLASS_NAME = HomeLayout.ID + "-title-bar";

    private final HomeLayoutTitleRouterLink image;

    public HomeLayoutTitleBar(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        image = new HomeLayoutTitleRouterLink(dataProvider);
        add(image);
    }
}
