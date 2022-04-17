package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.home.HomeView;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;
import static org.karp.k4t.ui.landing.LandingView.ROUTE;

@Route(value = ROUTE)
@PageTitle(HomeView.NAME)
@CssImport(FOLDER + LandingView.ID + CSS_FILE_EXTENSION)
@RouteAlias(value = EMPTY)
public class LandingView extends VerticalLayout {

    public static final String ROUTE = "landing";
    public static final String ID_PREFIX = "landing";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Landing";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public LandingView() {
        addClassName(ID);
        setAlignItems(CENTER);
        Text text = new Text(NAME);
        add(text);
        RouterLink homeRouterLink = new RouterLink();
        homeRouterLink.setText("Home");
        homeRouterLink.setRoute(HomeView.class);
        add(homeRouterLink);
    }
}
