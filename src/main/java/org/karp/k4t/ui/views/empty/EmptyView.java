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
import static org.karp.k4t.ui.views.empty.EmptyView.FOLDER;
import static org.karp.k4t.ui.views.empty.EmptyView.ID;

@Route(value = EmptyView.ROUTE, layout = MainLayout.class)
@PageTitle(EmptyView.NAME)
@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class EmptyView extends VerticalLayout {

    public static final String ROUTE = "empty";
    public static final String ID_PREFIX = "empty";
    public static final String ID_SUFFIX = "-view";
    public static final String ID = ID_PREFIX + ID_SUFFIX;
    public static final String NAME = "Empty";
    public static final VaadinIcon ICON = THIN_SQUARE;
    public static final String FOLDER = VIEWS_FOLDER + ID_PREFIX + "/";

    public EmptyView() {
        setId(ID);

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
