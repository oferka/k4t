package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H3;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.MAIN_FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerFooter.ID;

@CssImport(MAIN_FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutDrawerFooter extends Footer {

    public static final String ID = MainLayoutDrawer.ID + "-footer";

    public MainLayoutDrawerFooter() {
        addClassName(ID);
        add(new H3("footer"));
    }
}
