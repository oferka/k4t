package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.karp.k4t.ui.home.HomeView;

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
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    private final LandingViewHeader header;
    private final LandingViewBody body;
    private final LandingViewFooter footer;

    public LandingView() {
        addClassName(ID);

        header = new LandingViewHeader();
        add(header);

        body = new LandingViewBody();
        addAndExpand(body);

        footer = new LandingViewFooter();
        add(footer);
    }
}
