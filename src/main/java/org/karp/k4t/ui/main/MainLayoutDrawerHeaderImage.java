package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.main.MainLayout.ID_PREFIX;
import static org.karp.k4t.ui.main.MainLayoutDrawerHeaderImage.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutDrawerHeaderImage extends Image {

    public static final String ID_SUFFIX = "main-layout-drawer-header-image";

    public MainLayoutDrawerHeaderImage() {
        setId(ID_SUFFIX);

        setSrc("images/logo.png");
        setAlt("K4T logo");
    }
}