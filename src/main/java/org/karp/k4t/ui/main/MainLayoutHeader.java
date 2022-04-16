package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import javax.validation.constraints.NotNull;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeader.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutHeader extends HorizontalLayout {

    public static final String ID = MainLayout.ID + "-header";

    private final MainLayoutDrawerToggle mainLayoutDrawerToggle;
    private final MainLayoutTitle mainLayoutTitle;
    private final MainLayoutActions mainLayoutActions;

    public MainLayoutHeader() {
        addClassName(ID);
        setWidthFull();
        setSpacing(false);
        setAlignItems(FlexComponent.Alignment.CENTER);
        mainLayoutDrawerToggle = new MainLayoutDrawerToggle();
        add(mainLayoutDrawerToggle);
        mainLayoutTitle = new MainLayoutTitle();
        add(mainLayoutTitle);
        mainLayoutActions = new MainLayoutActions();
        add(mainLayoutActions);
    }

    public void setTitleText(@NotNull String titleText) {
        mainLayoutTitle.setTitleText(titleText);
    }
}
