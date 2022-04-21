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

    private Optional<SearchTerm> searchTerm = Optional.empty();

    public void addSearchTermChangeListener(SearchTermChangeListener listener) {
        searchTermChangeListeners.add(listener);
    }

    public void removeSearchTermChangeListener(SearchTermChangeListener listener) {
        searchTermChangeListeners.remove(listener);
    }

    public Optional<SearchTerm> getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(Optional<SearchTerm> searchTerm) {
        if(!searchTerm.equals(this.searchTerm)) {
            fireSearchTermChangeEvent(new SearchTermChangeEvent(this.searchTerm, searchTerm));
        }
        this.searchTerm = searchTerm;
    }

    private void fireSearchTermChangeEvent(SearchTermChangeEvent event) {
        for(SearchTermChangeListener listener : searchTermChangeListeners) {
            listener.searchTermChanged(event);
        }
    }
}
