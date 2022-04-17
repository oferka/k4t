package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import javax.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeader.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutHeader extends HorizontalLayout {

    public static final String ID = MainLayout.ID + "-header";

    private final MainLayoutHeaderDrawerToggle drawerToggle;
    private final MainLayoutHeaderTitle title;
    private final MainLayoutHeaderActions actions;

    public MainLayoutHeader() {
        addClassName(ID);
        setWidthFull();
        setSpacing(false);
        setAlignItems(CENTER);
        drawerToggle = new MainLayoutHeaderDrawerToggle();
        add(drawerToggle);
        title = new MainLayoutHeaderTitle();
        add(title);
        actions = new MainLayoutHeaderActions();
        add(actions);
    }

    public void setTitleText(@NotNull String titleText) {
        title.setTitleText(titleText);
    }
}
