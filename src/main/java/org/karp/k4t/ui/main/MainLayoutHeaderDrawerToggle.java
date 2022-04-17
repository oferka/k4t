package org.karp.k4t.ui.main;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeaderDrawerToggle.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutHeaderDrawerToggle extends DrawerToggle {

    public static final String ID = MainLayoutHeader.ID + "-drawer-toggle";

    public MainLayoutHeaderDrawerToggle() {
        addClassName(ID);
        addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        getElement().setAttribute("aria-label", "Menu toggle");
    }
}
