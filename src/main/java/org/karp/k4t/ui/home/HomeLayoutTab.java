package org.karp.k4t.ui.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.ui.DataProvider;

import static java.lang.String.format;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTab.CLASS_NAME + CSS_FILE_EXTENSION)
public class HomeLayoutTab extends Tab {

    public static final String CLASS_NAME = HomeLayout.ID + "-tab";

    private final String text;

    public  HomeLayoutTab(DataProvider dataProvider, String text, Class<? extends Component> navigationTarget) {
        this.text = text;
        addClassName(CLASS_NAME);
        setId(format("%s-%s", CLASS_NAME, text));
        add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(this, Class.class, navigationTarget);
    }

    public String getText() {
        return text;
    }
}
