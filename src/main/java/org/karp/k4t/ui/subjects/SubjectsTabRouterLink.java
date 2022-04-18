package org.karp.k4t.ui.subjects;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.router.RouterLink;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.subjects.SubjectsView.FOLDER;

@CssImport(FOLDER + SubjectsTabRouterLink.ID + CSS_FILE_EXTENSION)
public class SubjectsTabRouterLink extends RouterLink {

    public static final String ID = SubjectsTab.ID + "-router-link";

    public SubjectsTabRouterLink() {
        addClassName(ID);
        setRoute(SubjectsView.class);
        setText("Subjects");
    }
}
