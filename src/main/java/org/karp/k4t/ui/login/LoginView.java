package org.karp.k4t.ui.login;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.login.LoginView.FOLDER;
import static org.karp.k4t.ui.login.LoginView.ROUTE;

@Route(ROUTE)
@PageTitle(LoginView.NAME)
@CssImport(FOLDER + LoginView.CLASS_NAME + CSS_FILE_EXTENSION)
public class LoginView extends VerticalLayout {

    public static final String ROUTE = "login";
    public static final String ID_PREFIX = "login";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Login";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public LoginView() {
        addClassName(CLASS_NAME);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
        getStyle().set("padding", "2em");

        Text text = new Text(NAME);
        add(text);
    }
}
