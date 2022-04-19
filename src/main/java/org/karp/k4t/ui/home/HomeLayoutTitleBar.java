package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTitleBar.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTitleBar extends HorizontalLayout {

    public static final String ID = HomeLayout.ID + "-title-bar";

    private final HomeLayoutTitleImage image;
    private final HomeLayoutTitleText text;

    public HomeLayoutTitleBar() {
        addClassName(ID);
        setAlignItems(CENTER);

        image = new HomeLayoutTitleImage();
        add(image);

        text = new HomeLayoutTitleText();
        add(text);
    }
}
