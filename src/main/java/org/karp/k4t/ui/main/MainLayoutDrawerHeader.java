package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.shared.ApplicationImage;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerHeader.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutDrawerHeader extends HorizontalLayout {

    public static final String CLASS_NAME = MainLayoutDrawer.CLASS_NAME + "-header";

    private final ApplicationImage image;
    private final MainLayoutDrawerHeaderTitle title;

    public MainLayoutDrawerHeader(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setAlignItems(CENTER);

        image = new ApplicationImage(dataProvider);
        add(image);

        title = new MainLayoutDrawerHeaderTitle(dataProvider);
        add(title);
    }
}
