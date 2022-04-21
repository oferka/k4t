package org.karp.k4t.ui.home;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.PageTitle;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.search.terms.SearchState;

import static java.lang.String.format;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@Slf4j
@CssImport(FOLDER + HomeLayout.ID + CSS_FILE_EXTENSION)
public class HomeLayout extends AppLayout {

    public static final String ID_PREFIX = "home";
    public static final String ID = ID_PREFIX + "-layout";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    private final HomeLayoutHeader header;

    public HomeLayout(DataProvider dataProvider, SearchState searchState) {
        setId(ID);

        header = new HomeLayoutHeader(dataProvider, searchState);
        addToNavbar(true, header);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        log.info(format("Selected view page title: %s", getCurrentPageTitle()));
        header.presentTab(getContent());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
