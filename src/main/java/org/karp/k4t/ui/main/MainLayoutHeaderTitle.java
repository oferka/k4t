package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeaderTitle.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutHeaderTitle extends H1 {

    public static final String ID = MainLayoutHeader.ID + "-title";

    public MainLayoutHeaderTitle() {
        addClassName(ID);
    }

    public void setTitleText(@NotNull String titleText) {
        setText(titleText);
    }
}