package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + SearchTextField.ID + CSS_FILE_EXTENSION)
public class SearchTextField extends TextField {

    public static final String ID = "search-text-field";

    public SearchTextField() {
        addClassName(ID);

        getElement().setAttribute("aria-label", "search");
        setPlaceholder("Search");
        setClearButtonVisible(true);
        setPrefixComponent(VaadinIcon.SEARCH.create());
    }
}
