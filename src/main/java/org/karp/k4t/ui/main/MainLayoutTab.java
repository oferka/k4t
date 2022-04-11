package org.karp.k4t.ui.main;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutTab.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutTab extends Tab {

    public static final String ID = MainLayout.ID + "-tab";

    private final MainLayoutTabRouterLink mainLayoutTabRouterLink;

    public MainLayoutTab(String viewId, String text, Class<? extends Component> navigationTarget, VaadinIcon vaadinIcon) {
        addClassName(ID);
        mainLayoutTabRouterLink = new MainLayoutTabRouterLink(text, navigationTarget, vaadinIcon);
        add(mainLayoutTabRouterLink);
        ComponentUtil.setData(this, Class.class, navigationTarget);
    }
}
