package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.Key.KEY_K;
import static com.vaadin.flow.component.KeyModifier.ALT;
import static org.karp.k4t.Application.APPLICATION_LOGO;
import static org.karp.k4t.Application.APPLICATION_NAME;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@Slf4j
@CssImport(SHARED_FOLDER + ApplicationImage.CLASS_NAME + CSS_FILE_EXTENSION)
public class ApplicationImage extends Image {

    public static final String CLASS_NAME = "application-image";

    public ApplicationImage(DataProvider dataProvider) {
        addClassName(CLASS_NAME);
        setSrc(APPLICATION_LOGO);
        setAlt(APPLICATION_NAME);
        addClickListener(this::applicationImageClicked);
        addClickShortcut(KEY_K, ALT);
    }

    private void applicationImageClicked(ClickEvent<Image> event) {
        log.info("Application Image Clicked");
    }
}
