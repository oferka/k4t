package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import org.karp.k4t.ui.shared.ApplicationTitleText;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTitleText.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTitleText extends Div {

    public static final String ID = HomeLayout.ID + "-title-text";

    private final ApplicationTitleText titleText;

    public HomeLayoutTitleText() {
        addClassName(ID);
        titleText = new ApplicationTitleText();
        add(titleText);
    }
}
