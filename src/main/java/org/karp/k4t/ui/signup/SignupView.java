package org.karp.k4t.ui.signup;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.signup.SignupView.FOLDER;
import static org.karp.k4t.ui.signup.SignupView.ROUTE;

@Route(ROUTE)
@PageTitle(SignupView.NAME)
@CssImport(FOLDER + SignupView.CLASS_NAME + CSS_FILE_EXTENSION)
public class SignupView extends VerticalLayout {

    public static final String ROUTE = "signup";
    public static final String ID_PREFIX = "signup";
    public static final String ID_SUFFIX = "-view";
    public static final String CLASS_NAME = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Sign Up";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public SignupView() {
        addClassName(CLASS_NAME);
        setSizeFull();
        setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        getStyle().set("text-align", "center");
        getStyle().set("padding", "2em");

        Text text = new Text(NAME);
        add(text);
    }
}
