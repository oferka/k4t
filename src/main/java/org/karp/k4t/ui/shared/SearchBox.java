package org.karp.k4t.ui.shared;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import elemental.json.JsonObject;
import org.karp.k4t.model.SearchTerm;
import org.karp.k4t.ui.DataProvider;

import static com.vaadin.flow.component.notification.Notification.Position.MIDDLE;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.SHARED_FOLDER;

@CssImport(SHARED_FOLDER + SearchBox.ID + CSS_FILE_EXTENSION)
public class SearchBox extends ComboBox<SearchTerm> {

    public static final String ID = "search-box";

    public SearchBox(DataProvider dataProvider) {
        addClassName(ID);

        getElement().setAttribute("aria-label", "search");
        setPlaceholder("Search");
        setClearButtonVisible(true);
        setAllowCustomValue(true);
        addCustomValueSetListener(this::customValueEntered);
        addSelectedItemChangeListener(this::selectedItemChanged);
        setItems(dataProvider.getSearchTermsDataProvider().findAll());
        setItemLabelGenerator(SearchTerm::getText);
    }

    private void selectedItemChanged(SelectedItemChangeEvent<ComboBox<SearchTerm>> comboBoxSelectedItemChangeEvent) {
        JsonObject selected = comboBoxSelectedItemChangeEvent.getSelectedItem();
        if(selected != null) {
            Notification.show("Search item selected: " + selected, 3000, MIDDLE);
        }
        else {
            Notification.show("Search selection cleaned", 3000, MIDDLE);
        }
    }

    private void customValueEntered(CustomValueSetEvent<ComboBox<SearchTerm>> customValueSetEvent) {
        String customValue = customValueSetEvent.getDetail();
        Notification.show("Search custom value entered: " + customValue, 3000, MIDDLE);
    }
}
