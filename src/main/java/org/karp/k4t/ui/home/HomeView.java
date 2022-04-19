package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;
import static org.karp.k4t.ui.home.HomeView.ROUTE;

@Route(value = ROUTE, layout = HomeLayout.class)
@RouteAlias(value = EMPTY, layout = HomeLayout.class)
@PageTitle(HomeView.NAME)
@CssImport(FOLDER + HomeView.ID + CSS_FILE_EXTENSION)
public class HomeView extends VerticalLayout {

    public static final String ROUTE = "home";
    public static final String ID_PREFIX = "home";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Home";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public HomeView() {
        addClassName(ID);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        getStyle().set("padding", "2em");

        Text text = new Text(NAME);
        add(text);
    }
}
