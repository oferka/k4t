package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import org.karp.k4t.Application;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerHeaderTitle.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutDrawerHeaderTitle extends H1 {

    public static final String ID = MainLayoutDrawerHeader.ID + "-title";

    public MainLayoutDrawerHeaderTitle() {
        addClassName(ID);
        setText(Application.APPLICATION_NAME);
    }
}
