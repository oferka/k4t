package org.karp.k4t.ui.main;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;

import static org.karp.k4t.ui.Styles.*;
import static org.karp.k4t.ui.main.MainLayout.FOLDER;
import static org.karp.k4t.ui.main.MainLayout.ID;

@JsModule(SHARED_STYLES_FILE)
@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class MainLayout extends AppLayout {

    private final MainLayoutHeader header;
    private final MainLayoutDrawer drawer;

    public static final String ID_PREFIX = "main";
    public static final String ID = ID_PREFIX + "-layout";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public MainLayout() {
        setId(ID);
        setPrimarySection(Section.DRAWER);
        header = new MainLayoutHeader();
        addToNavbar(true, header);
        drawer = new MainLayoutDrawer();
        addToDrawer(drawer);
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        drawer.selectTab(getContent());
        header.setTitleText(getCurrentPageTitle());
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
