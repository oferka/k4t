package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import javax.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeaderActions.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutHeaderContent extends HorizontalLayout {

    public static final String ID = MainLayoutHeader.ID + "-content";

    private final MainLayoutHeaderContentDrawerToggle drawerToggle;
    private final MainLayoutHeaderContentTitle title;

    public MainLayoutHeaderContent() {
        addClassName(ID);
        setSpacing(false);
        setAlignItems(CENTER);

        drawerToggle = new MainLayoutHeaderContentDrawerToggle();
        add(drawerToggle);

        title = new MainLayoutHeaderContentTitle();
        add(title);
    }

    public void setTitleText(@NotNull String titleText) {
        title.setTitleText(titleText);
    }
}
