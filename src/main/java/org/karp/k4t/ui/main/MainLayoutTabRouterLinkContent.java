package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.main.MainLayout.ID_PREFIX;
import static org.karp.k4t.ui.main.MainLayoutTabRouterLinkContent.VIEW_ID_SUFFIX;

@CssImport(VIEWS_FOLDER + ID_PREFIX + "/" + VIEW_ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayoutTabRouterLinkContent extends HorizontalLayout {

    public static final String VIEW_ID_SUFFIX = "main-layout-tab-router-link-content";
    public static String ID_SUFFIX = "-content";

    public MainLayoutTabRouterLinkContent(String mainLayoutTabRouterLinkId, String text, VaadinIcon vaadinIcon) {
        setId(mainLayoutTabRouterLinkId + ID_SUFFIX);

        Span span = new Span(text);
        Icon icon = new Icon(vaadinIcon);
        add(icon, span);
        setVerticalComponentAlignment(FlexComponent.Alignment.CENTER, icon, span);
    }
}
