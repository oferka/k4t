package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.shared.ApplicationImage;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTitleImage.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTitleImage extends Div {

    public static final String ID = HomeLayout.ID + "-title-image";

    private final ApplicationImage applicationImage;

    public HomeLayoutTitleImage(DataProvider dataProvider) {
        addClassName(ID);

        applicationImage = new ApplicationImage(dataProvider);
        add(applicationImage);
    }
}
