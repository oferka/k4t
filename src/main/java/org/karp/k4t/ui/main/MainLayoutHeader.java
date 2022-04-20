package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import javax.validation.constraints.NotNull;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeader.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutHeader extends HorizontalLayout {

    public static final String ID = MainLayout.ID + "-header";

    private final MainLayoutHeaderContent content;
    private final MainLayoutHeaderActions actions;

    public MainLayoutHeader(DataProvider dataProvider) {
        addClassName(ID);
        setWidthFull();
        setPadding(true);
        setJustifyContentMode(BETWEEN);

        content = new MainLayoutHeaderContent(dataProvider);
        add(content);

        actions = new MainLayoutHeaderActions(dataProvider);
        add(actions);
    }

    public void setTitleText(@NotNull String titleText) {
        content.setTitleText(titleText);
    }
}
