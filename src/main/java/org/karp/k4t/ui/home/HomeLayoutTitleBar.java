package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTitleBar.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTitleBar extends HorizontalLayout {

    public static final String ID = HomeLayout.ID + "-title-bar";

    private final HomeLayoutTitleImage image;

    public HomeLayoutTitleBar(DataProvider dataProvider) {
        addClassName(ID);
        setAlignItems(CENTER);

        image = new HomeLayoutTitleImage(dataProvider);
        add(image);
    }
}
