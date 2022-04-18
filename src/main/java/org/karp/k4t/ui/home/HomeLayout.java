package org.karp.k4t.ui.home;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.PageTitle;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayout.ID + CSS_FILE_EXTENSION)
public class HomeLayout extends AppLayout {

    public static final String ID_PREFIX = "home";
    public static final String ID = ID_PREFIX + "-layout";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    private final HomeLayoutHeader header;

    public HomeLayout() {
        setId(ID);

        header = new HomeLayoutHeader();
        addToNavbar(true, header);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        header.selectTab(getContent());
        header.setTitleText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
