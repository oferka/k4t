package org.karp.k4t.ui.main;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.MAIN_FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawerToggle.ID;

@CssImport(MAIN_FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutDrawerToggle extends DrawerToggle {

    public static final String ID = MainLayoutDrawer.ID + "-toggle";

    public MainLayoutDrawerToggle() {
        addClassName(ID);
        addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        getElement().setAttribute("aria-label", "Menu toggle");
    }
}
