package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.main.MainLayout.ID_PREFIX;
import static org.karp.k4t.ui.main.MainLayoutDrawer.ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ID_PREFIX + "/" + ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutDrawer extends VerticalLayout {

    public static final String ID_SUFFIX = "main-layout-drawer";

    private final MainLayoutDrawerHeader mainLayoutDrawerHeader;
    private final MainLayoutTabs mainLayoutTabs;
    private final MainLayoutDrawerFooter mainLayoutDrawerFooter;

    public MainLayoutDrawer() {
        setId(ID_SUFFIX);

        getThemeList().set("dark", true);
        setSizeFull();
        setPadding(false);
        setSpacing(false);
        setAlignItems(FlexComponent.Alignment.STRETCH);

        mainLayoutDrawerHeader = new MainLayoutDrawerHeader();
        mainLayoutTabs = new MainLayoutTabs();
        mainLayoutDrawerFooter = new MainLayoutDrawerFooter();

        add(mainLayoutDrawerHeader, mainLayoutTabs, mainLayoutDrawerFooter);
    }

    public void selectTab(Component content) {
        mainLayoutTabs.selectTab(content);
    }
}
