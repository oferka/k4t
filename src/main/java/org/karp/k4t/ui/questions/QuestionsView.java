package org.karp.k4t.ui.questions;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.home.HomeLayout;

import static com.vaadin.flow.component.icon.VaadinIcon.LINES_LIST;
import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.questions.QuestionsView.FOLDER;

@Route(value = QuestionsView.ROUTE, layout = HomeLayout.class)
@PageTitle(QuestionsView.NAME)
@CssImport(FOLDER + QuestionsView.ID + CSS_FILE_EXTENSION)
public class QuestionsView extends HorizontalLayout {

    public static final String ROUTE = "questions";
    public static final String ID_PREFIX = "questions";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Questions";
    public static final VaadinIcon ICON = LINES_LIST;
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public QuestionsView() {
        addClassName(ID);
        setAlignItems(CENTER);
        Text text = new Text(NAME);
        add(text);
    }
}
