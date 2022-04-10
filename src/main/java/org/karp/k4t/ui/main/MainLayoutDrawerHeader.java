package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.MAIN_FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerHeader.ID_SUFFIX;

@CssImport(MAIN_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutDrawerHeader extends HorizontalLayout {

    public static final String ID_SUFFIX = "main-layout-drawer-header";

    private final MainLayoutDrawerHeaderImage mainLayoutDrawerHeaderImage;
    private final MainLayoutDrawerHeaderTitle mainLayoutDrawerHeaderTitle;

    public MainLayoutDrawerHeader() {
        setId(ID_SUFFIX);
        setAlignItems(CENTER);

        mainLayoutDrawerHeaderImage = new MainLayoutDrawerHeaderImage();
        add(mainLayoutDrawerHeaderImage);

        mainLayoutDrawerHeaderTitle = new MainLayoutDrawerHeaderTitle();
        add(mainLayoutDrawerHeaderTitle);
    }
}
