package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;
import org.karp.k4t.ui.DataProvider;
import org.karp.k4t.ui.automation.runner.views.home.HomeLayoutTabRouterLink;

import static java.lang.String.format;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTab.CLASS_NAME + CSS_FILE_EXTENSION)
public class HomeLayoutTab extends Tab {

    public static final String CLASS_NAME = HomeLayout.ID + "-tab";

    private final String text;

    private final HomeLayoutTabRouterLink homeLayoutTabRouterLink;

    public  HomeLayoutTab(DataProvider dataProvider, String text, Class<? extends Component> navigationTarget) {
        this.text = text;
        addClassName(CLASS_NAME);
        setId(format("%s-%s", CLASS_NAME, text));
        homeLayoutTabRouterLink = new HomeLayoutTabRouterLink(dataProvider, text, navigationTarget);
        add(homeLayoutTabRouterLink);
        ComponentUtil.setData(this, Class.class, navigationTarget);
    }

    public String getText() {
        return text;
    }
}
