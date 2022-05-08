package org.karp.k4t.ui.automation.runner.views.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.home.HomeLayoutTab;

import static java.lang.String.format;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTabRouterLink.CLASS_NAME + CSS_FILE_EXTENSION)
public class HomeLayoutTabRouterLink extends RouterLink {

    public static final String CLASS_NAME = HomeLayoutTab.CLASS_NAME + "-router-link";

    public  HomeLayoutTabRouterLink(DataProvider dataProvider, String text, Class<? extends Component> navigationTarget) {
        super(text, navigationTarget);
        addClassName(CLASS_NAME);
        setId(format("%s-%s", CLASS_NAME, text));
    }
}
