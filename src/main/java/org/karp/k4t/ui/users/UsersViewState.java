package org.karp.k4t.ui.users;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.ArrayList;
import java.util.List;

import static org.karp.k4t.ui.users.UserViewPresentationMode.GRID;

@SpringComponent
@UIScope
public class UsersViewState {

    private List<UsersViewPresentationModeChangeListener> usersViewPresentationModeChangeListeners = new ArrayList<>();

    private UserViewPresentationMode presentationMode = GRID;

    public void addPresentationModeChangeListener(UsersViewPresentationModeChangeListener listener) {
        usersViewPresentationModeChangeListeners.add(listener);
    }

    public void removePresentationModeChangeListener(UsersViewPresentationModeChangeListener listener) {
        usersViewPresentationModeChangeListeners.remove(listener);
    }

    public UserViewPresentationMode getPresentationMode() {
        return presentationMode;
    }

    public void setPresentationMode(UserViewPresentationMode presentationMode) {
        if(presentationMode != this.presentationMode) {
            fireUsersViewPresentationModeChangeEvent(new UsersViewPresentationModeChangeEvent(this.presentationMode, presentationMode));
        }
        this.presentationMode = presentationMode;
    }

    private void fireUsersViewPresentationModeChangeEvent(UsersViewPresentationModeChangeEvent event) {
        for(UsersViewPresentationModeChangeListener listener : usersViewPresentationModeChangeListeners) {
            listener.presentationModeChanged(event);
        }
    }
}
