package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.MAIN_FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerHeaderTitle.ID_SUFFIX;

@CssImport(MAIN_FOLDER + ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutDrawerHeaderTitle extends H1 {

    public static final String ID_SUFFIX = "main-layout-drawer-header-title";

    public MainLayoutDrawerHeaderTitle() {
        setId(ID_SUFFIX);
            setText("K4T");
    }
}
