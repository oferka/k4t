package org.karp.k4t.ui.feed;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.main.MainLayout;

import static com.vaadin.flow.component.icon.VaadinIcon.LINES_LIST;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.feed.FeedView.FOLDER;
import static org.karp.k4t.ui.feed.FeedView.ID;

@Route(value = FeedView.ROUTE, layout = MainLayout.class)
@PageTitle(FeedView.NAME)
@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class FeedView extends HorizontalLayout {

    public static final String ROUTE = "feed";
    public static final String ID_PREFIX = "feed";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Feed";
    public static final VaadinIcon ICON = LINES_LIST;
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public FeedView() {
        addClassName(ID);
        setAlignItems(CENTER);

        Text text = new Text(NAME);
        add(text);
    }
}
