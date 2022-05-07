package org.karp.k4t.ui.main;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import org.karp.k4t.ui.DataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeaderContentDrawerToggle.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutHeaderContentDrawerToggle extends DrawerToggle {

    public static final String CLASS_NAME = MainLayoutHeaderContent.CLASS_NAME + "-drawer-toggle";

    public MainLayoutHeaderContentDrawerToggle(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        getElement().setAttribute("aria-label", "Menu toggle");
    }
}
