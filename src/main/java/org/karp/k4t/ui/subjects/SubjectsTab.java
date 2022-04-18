package org.karp.k4t.ui.subjects;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.tabs.Tab;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.subjects.SubjectsView.FOLDER;

@CssImport(FOLDER + SubjectsTab.ID + CSS_FILE_EXTENSION)
public class SubjectsTab extends Tab {

    public static final String ID = "subjects-tab";

    private final SubjectsTabRouterLink subjectsTabRouterLink;

    public SubjectsTab() {
        addClassName(ID);
        subjectsTabRouterLink = new SubjectsTabRouterLink();
        add(subjectsTabRouterLink);
    }
}
