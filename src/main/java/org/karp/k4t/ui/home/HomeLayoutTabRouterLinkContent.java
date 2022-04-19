package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTabRouterLink.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTabRouterLinkContent extends HorizontalLayout {

    public static final String ID = HomeLayoutTabRouterLink.ID + "-content";

    public HomeLayoutTabRouterLinkContent(String text, VaadinIcon icon) {
        addClassName(ID);
        Span span = new Span(text);
        add(icon.create(), span);
    }
}
