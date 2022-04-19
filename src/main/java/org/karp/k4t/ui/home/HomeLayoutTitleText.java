package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTitleText.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTitleText extends H1 {

    public static final String ID = HomeLayout.ID + "-title-text";

    public HomeLayoutTitleText() {
        addClassName(ID);
    }

    public void setTitleText(String titleText) {
        setText(titleText);
    }
}
