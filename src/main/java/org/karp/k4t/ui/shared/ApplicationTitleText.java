package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;

import static org.karp.k4t.Application.APPLICATION_NAME;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + ApplicationTitleText.ID + CSS_FILE_EXTENSION)
public class ApplicationTitleText extends H1 {

    public static final String ID = "application-title-text";

    public ApplicationTitleText() {
        super(APPLICATION_NAME);
        addClassName(ID);
    }
}
