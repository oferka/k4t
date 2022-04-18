package org.karp.k4t.ui.home;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.home.HomeLayout.FOLDER;

@CssImport(FOLDER + HomeLayoutTitle.ID + CSS_FILE_EXTENSION)
public class HomeLayoutTitle extends H3 {

    public static final String ID = HomeLayout.ID + "-title";

    public HomeLayoutTitle() {
        addClassName(ID);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}
