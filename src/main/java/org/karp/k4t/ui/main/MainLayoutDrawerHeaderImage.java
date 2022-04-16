package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerHeaderImage.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutDrawerHeaderImage extends Image {

    public static final String ID = MainLayoutDrawerHeader.ID + "-image";

    public MainLayoutDrawerHeaderImage() {
        addClassName(ID);
        setSrc("images/logo.png");
        setAlt("K4T logo");
    }
}
