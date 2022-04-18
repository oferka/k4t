package org.karp.k4t.ui.subjects;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.feed.FeedView.FOLDER;
import static org.karp.k4t.ui.feed.FeedView.ID;

@Route(value = SubjectsView.ROUTE)
@PageTitle(SubjectsView.NAME)
@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class SubjectsView extends HorizontalLayout {

    public static final String ROUTE = "subjects";
    public static final String ID_PREFIX = "subjects";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Subjects";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public SubjectsView() {
        addClassName(ID);
        setAlignItems(CENTER);
        Text text = new Text(NAME);
        add(text);
    }
}
