package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import org.karp.k4t.Application;
import org.karp.k4t.ui.DataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerHeaderTitle.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutDrawerHeaderTitle extends H1 {

    public static final String CLASS_NAME = MainLayoutDrawerHeader.CLASS_NAME + "-title";

    public MainLayoutDrawerHeaderTitle(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setText(Application.APPLICATION_NAME);
    }
}
