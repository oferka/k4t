package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.karp.k4t.ui.main.MainLayout;

import static com.vaadin.flow.component.icon.VaadinIcon.HOME_O;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.home.HomeView.HOME_ROUTE;

@Route(value = HOME_ROUTE, layout = MainLayout.class)
@PageTitle(HomeView.HOME_VIEW_NAME)
@CssImport(VIEWS_FOLDER + HomeView.HOME_ID_PREFIX + "/" + HomeView.HOME_VIEW_ID + CSS_FILE_EXTENSION)
@RouteAlias(value = "", layout = MainLayout.class)
public class HomeView extends HorizontalLayout {

    public static final String HOME_ROUTE = "home";
    public static final String HOME_ID_PREFIX = "home";
    public static final String HOME_ID_SUFFIX = "-view";
    public static final String HOME_VIEW_ID = HOME_ID_PREFIX + HOME_ID_SUFFIX;
    public static final String HOME_VIEW_NAME = "Home";
    public static final VaadinIcon HOME_VIEW_ICON = HOME_O;

    public HomeView() {
        setId(HOME_VIEW_ID);
        setAlignItems(CENTER);

        Text text = new Text(HOME_VIEW_NAME);
        add(text);
    }
}
