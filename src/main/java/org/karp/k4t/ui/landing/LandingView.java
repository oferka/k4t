package org.karp.k4t.ui.landing;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.DataProvider;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.landing.LandingView.FOLDER;
import static org.karp.k4t.ui.landing.LandingView.ROUTE;

@Route(value = ROUTE)
@PageTitle(LandingView.NAME)
@CssImport(FOLDER + LandingView.ID + CSS_FILE_EXTENSION)
public class LandingView extends VerticalLayout {

    public static final String ROUTE = "landing";
    public static final String ID_PREFIX = "landing";
    public static final String NAME = "Landing";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    private final LandingViewHeader header;
    private final LandingViewBody body;
    private final LandingViewFooter footer;

    public LandingView(DataProvider dataProvider) {
        addClassName(ID);

        header = new LandingViewHeader(dataProvider);
        add(header);

        body = new LandingViewBody(dataProvider);
        addAndExpand(body);

        footer = new LandingViewFooter(dataProvider);
        add(footer);
    }
}
