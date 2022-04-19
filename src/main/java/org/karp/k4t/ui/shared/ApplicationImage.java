package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;

import static org.karp.k4t.Application.APPLICATION_LOGO;
import static org.karp.k4t.Application.APPLICATION_NAME;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + ApplicationImage.ID + CSS_FILE_EXTENSION)
public class ApplicationImage extends Image {

    public static final String ID = "application-image";

    public ApplicationImage() {
        addClassName(ID);
        setSrc(APPLICATION_LOGO);
        setAlt(APPLICATION_NAME);
    }
}
