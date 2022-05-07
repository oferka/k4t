package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import org.karp.k4t.ui.DataProvider;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeaderContentTitle.CLASS_NAME;

@CssImport(FOLDER + CLASS_NAME + CSS_FILE_EXTENSION)
public class MainLayoutHeaderContentTitle extends H1 {

    public static final String CLASS_NAME = MainLayoutHeaderContent.CLASS_NAME + "-title";

    public MainLayoutHeaderContentTitle(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}