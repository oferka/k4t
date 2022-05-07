package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H3;
import org.karp.k4t.ui.DataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerFooter.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutDrawerFooter extends Footer {

    public static final String CLASS_NAME = MainLayoutDrawer.CLASS_NAME + "-footer";

    public MainLayoutDrawerFooter(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        add(new H3("footer"));
    }
}
