package org.karp.k4t.ui.views.empty;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.main.MainLayout;

import static com.vaadin.flow.component.icon.VaadinIcon.THIN_SQUARE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;

@Route(value = EmptyView.EMPTY_ROUTE, layout = MainLayout.class)
@PageTitle(EmptyView.EMPTY_VIEW_NAME)
@CssImport(VIEWS_FOLDER + EmptyView.EMPTY_ROUTE + "/" + EmptyView.EMPTY_VIEW_ID + CSS_FILE_EXTENSION)
public class EmptyView extends VerticalLayout {

    public static final String EMPTY_ROUTE = "empty";
    public static final String EMPTY_ID_PREFIX = "empty";
    public static final String EMPTY_ID_SUFFIX = "-view";
    public static final String EMPTY_VIEW_ID = EMPTY_ID_PREFIX + EMPTY_ID_SUFFIX;
    public static final String EMPTY_VIEW_NAME = "Empty";
    public static final VaadinIcon EMPTY_VIEW_ICON = THIN_SQUARE;

    public EmptyView() {
        setId(EMPTY_VIEW_ID);

        setSpacing(false);

        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        add(new H2("This place intentionally left empty"));
        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
