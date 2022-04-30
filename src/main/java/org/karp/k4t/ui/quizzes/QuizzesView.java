package org.karp.k4t.ui.quizzes;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.home.HomeLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.quizzes.QuizzesView.FOLDER;
import static org.karp.k4t.ui.quizzes.QuizzesView.ROUTE;

@Route(value = ROUTE, layout = HomeLayout.class)
@PageTitle(QuizzesView.NAME)
@CssImport(FOLDER + QuizzesView.ID + CSS_FILE_EXTENSION)
public class QuizzesView extends VerticalLayout {

    public static final String ROUTE = "quizzes";
    public static final String ID_PREFIX = "quizzes";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Quizzes";
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public QuizzesView() {
        addClassName(ID);
        setAlignItems(CENTER);
        Span text = new Span(NAME);
        text.addClassName(ID.concat("-text"));
        add(text);
    }
}
