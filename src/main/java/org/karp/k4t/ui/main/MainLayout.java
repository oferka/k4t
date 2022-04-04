package org.karp.k4t.ui.main;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;

import static org.karp.k4t.ui.Styles.*;

@JsModule(SHARED_STYLES_FILE)
@CssImport(VIEWS_FOLDER + MainLayout.ID_PREFIX + "/" + MainLayout.ID_SUFFIX + CSS_FILE_EXTENSION)
public class MainLayout extends AppLayout {

    private final MainLayoutHeader mainLayoutHeader;
    private final MainLayoutDrawer mainLayoutDrawer;

    public static final String ID_PREFIX = "main";
    public static final String ID_SUFFIX = "main-layout";

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

//    private Component createDrawerContent() {
//        H2 appName = new H2("k4t");
//        appName.addClassNames("app-name");
//
//        com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
//                createNavigation(), createFooter());
//        section.addClassNames("drawer-section");
//        return section;
//    }

//    private Nav createNavigation() {
//        Nav nav = new Nav();
//        nav.addClassNames("menu-item-container");
//        nav.getElement().setAttribute("aria-labelledby", "views");
//
//        // Wrap the links in a list; improves accessibility
//        UnorderedList list = new UnorderedList();
//        list.addClassNames("navigation-list");
//        nav.add(list);
//
//        for (MenuItemInfo menuItem : createMenuItems()) {
//            list.add(menuItem);
//
//        }
//        return nav;
//    }

//    private MenuItemInfo[] createMenuItems() {
//        return new MenuItemInfo[]{ //
//                new MenuItemInfo("Hello World", "la la-globe", HelloWorldView.class), //
//
//                new MenuItemInfo("Empty", "la la-file", EmptyView.class), //
//
//        };
//    }

//    private Footer createFooter() {
//        Footer layout = new Footer();
//        layout.addClassNames("footer");
//
//        return layout;
//    }

//    @Override
//    protected void afterNavigation() {
//        super.afterNavigation();
//        viewTitle.setText(getCurrentPageTitle());
//    }

//    private String getCurrentPageTitle() {
//        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
//        return title == null ? "" : title.value();
//    }

//    /**
//     * A simple navigation item component, based on ListItem element.
//     */
//    public static class MenuItemInfo extends ListItem {
//
//        private final Class<? extends Component> view;
//
//        public MenuItemInfo(String menuTitle, String iconClass, Class<? extends Component> view) {
//            this.view = view;
//            RouterLink link = new RouterLink();
//            link.addClassNames("menu-item-link");
//            link.setRoute(view);
//
//            Span text = new Span(menuTitle);
//            text.addClassNames("menu-item-text");
//
//            link.add(new LineAwesomeIcon(iconClass), text);
//            add(link);
//        }

//        public Class<?> getView() {
//            return view;
//        }

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
