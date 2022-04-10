package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.MAIN_FOLDER;

@CssImport(MAIN_FOLDER + MainLayoutTab.VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutTab extends Tab {

    public static final String VIEW_ID_SUFFIX = "main-layout-tab";
    public static String ID_SUFFIX = "-tab";

    private final MainLayoutTabRouterLink mainLayoutTabRouterLink;

    public MainLayoutTab(String viewId, String text, Class<? extends Component> navigationTarget, VaadinIcon vaadinIcon) {
        String id = viewId + ID_SUFFIX;
        setId(id);
        mainLayoutTabRouterLink = new MainLayoutTabRouterLink(id, text, navigationTarget, vaadinIcon);
        add(mainLayoutTabRouterLink);
        ComponentUtil.setData(this, Class.class, navigationTarget);
    }
}
