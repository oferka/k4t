package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutTabRouterLinkContent.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutTabRouterLinkContent extends HorizontalLayout {

    public static final String ID = MainLayoutTabRouterLink.ID + "-content";

    public MainLayoutTabRouterLinkContent(String text, VaadinIcon vaadinIcon) {
        addClassName(ID);
        Span span = new Span(text);
        Icon icon = new Icon(vaadinIcon);
        add(icon, span);
        setVerticalComponentAlignment(CENTER, icon, span);
    }
}
