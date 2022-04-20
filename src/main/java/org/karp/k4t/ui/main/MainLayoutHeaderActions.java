package org.karp.k4t.ui.main;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayoutHeaderActions.ID;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayoutHeaderActions extends HorizontalLayout {

    public static final String ID = MainLayoutHeader.ID + "-actions";

    private final MainLayoutUserHelp mainLayoutUserHelp;
    private final MainLayoutUserSettings mainLayoutUserSettings;
    private final MainLayoutUserNotifications mainLayoutUserNotifications;
    private final MainLayoutUserAvatar mainLayoutUserAvatar;

    public MainLayoutHeaderActions(DataProvider dataProvider) {
        addClassName(ID);
        mainLayoutUserHelp = new MainLayoutUserHelp(dataProvider);
        mainLayoutUserSettings = new MainLayoutUserSettings(dataProvider);
        mainLayoutUserNotifications = new MainLayoutUserNotifications(dataProvider);
        mainLayoutUserAvatar = new MainLayoutUserAvatar(dataProvider);
        add(mainLayoutUserHelp, mainLayoutUserSettings, mainLayoutUserNotifications, mainLayoutUserAvatar);
        setVerticalComponentAlignment(CENTER, mainLayoutUserHelp, mainLayoutUserSettings, mainLayoutUserNotifications, mainLayoutUserAvatar);
    }
}
