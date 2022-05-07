package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.shared.ApplicationImage;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTitleRouterLink.CLASS_NAME + CSS_FILE_EXTENSION)
public class HomeLayoutTitleRouterLink extends RouterLink {

    public static final String CLASS_NAME = HomeLayout.ID + "-title-router-link";

    private final ApplicationImage applicationImage;

    public HomeLayoutTitleRouterLink(DataProvider dataProvider) {
        super(EMPTY, HomeView.class);
        addClassName(CLASS_NAME);

        applicationImage = new ApplicationImage(dataProvider);
        add(applicationImage);
    }
}
