package org.karp.k4t.ui.search.terms;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.karp.k4t.model.SearchTerm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringComponent
@UIScope
public class SearchState {

    private final List<SearchTermChangeListener> searchTermChangeListeners = new ArrayList<>();

    private Optional<String> searchTermText = Optional.empty();

    public void addSearchTermChangeListener(SearchTermChangeListener listener) {
        searchTermChangeListeners.add(listener);
    }

    public void removeSearchTermChangeListener(SearchTermChangeListener listener) {
        searchTermChangeListeners.remove(listener);
    }

    public Optional<String> getSearchTerm() {
        return searchTermText;
    }

    public void setSearchTerm(Optional<String> searchTermText) {
        if(!searchTermText.equals(this.searchTermText)) {
            fireSearchTermChangeEvent(new SearchTermChangeEvent(this.searchTermText, searchTermText));
        }
        this.searchTermText = searchTermText;
    }

    private void fireSearchTermChangeEvent(SearchTermChangeEvent event) {
        for(SearchTermChangeListener listener : searchTermChangeListeners) {
            listener.searchTermChanged(event);
        }
    }
}
