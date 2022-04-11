package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.STRETCH;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutDrawer.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutDrawer extends VerticalLayout {

    public static final String ID = MainLayout.ID + "-drawer";

    private final MainLayoutDrawerHeader mainLayoutDrawerHeader;
    private final MainLayoutTabs mainLayoutTabs;
    private final MainLayoutDrawerFooter mainLayoutDrawerFooter;

    public MainLayoutDrawer() {
        addClassName(ID);

        getThemeList().set("dark", true);
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(STRETCH);

        mainLayoutDrawerHeader = new MainLayoutDrawerHeader();
        mainLayoutTabs = new MainLayoutTabs();
        mainLayoutDrawerFooter = new MainLayoutDrawerFooter();

        add(mainLayoutDrawerHeader, mainLayoutTabs, mainLayoutDrawerFooter);
    }

    public void selectTab(Component content) {
        mainLayoutTabs.selectTab(content);
    }
}
