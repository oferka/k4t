package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H3;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.main.MainLayout.ID_PREFIX;
import static org.karp.k4t.ui.main.MainLayoutDrawerFooter.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutDrawerFooter extends Footer {

    public static final String ID_SUFFIX = "main-layout-drawer-footer";

    public MainLayoutDrawerFooter() {
        setId(ID_SUFFIX);
        add(new H3("footer"));
    }
}
