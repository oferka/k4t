package org.karp.k4t.ui.main;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;

import static org.karp.k4t.ui.Styles.*;

@JsModule(SHARED_STYLES_FILE)
@CssImport(MainLayout.MAIN_FOLDER + MainLayout.ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayout extends AppLayout {

    private final MainLayoutHeader mainLayoutHeader;
    private final MainLayoutDrawer mainLayoutDrawer;

    public static final String ID_PREFIX = "main";
    public static final String ID_SUFFIX = "main-layout";
    public static final String MAIN_FOLDER = VIEWS_FOLDER + MainLayout.ID_PREFIX + "/";

    public MainLayout() {
        setId(ID_SUFFIX);
        setPrimarySection(Section.DRAWER);

        mainLayoutHeader = new MainLayoutHeader();
        addToNavbar(true, mainLayoutHeader);

        mainLayoutDrawer = new MainLayoutDrawer();
        addToDrawer(mainLayoutDrawer);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        mainLayoutDrawer.selectTab(getContent());
        mainLayoutHeader.setTitleText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }

//        /**
//         * Simple wrapper to create icons using LineAwesome iconset. See
//         * https://icons8.com/line-awesome
//         */
//        @NpmPackage(value = "line-awesome", version = "1.3.0")
//        public static class LineAwesomeIcon extends Span {
//            public LineAwesomeIcon(String lineawesomeClassnames) {
//                addClassNames("menu-item-icon");
//                if (!lineawesomeClassnames.isEmpty()) {
//                    addClassNames(lineawesomeClassnames);
//                }
//            }
//        }
//    }
}
