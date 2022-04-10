package org.karp.k4t.ui.users.user;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.karp.k4t.ui.main.MainLayout;

import static com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER;
import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.Styles.VIEWS_FOLDER;
import static org.karp.k4t.ui.users.UsersView.USERS_ID_PREFIX;
import static org.karp.k4t.ui.users.UsersView.USERS_ROUTE;
import static org.karp.k4t.ui.users.user.UserView.USER_FOLDER;

@Route(value = USERS_ROUTE, layout = MainLayout.class)
@PageTitle(UserView.USER_VIEW_NAME)
@CssImport(USER_FOLDER + UserView.USER_VIEW_ID + CSS_FILE_EXTENSION)
public class UserView extends VerticalLayout implements HasUrlParameter<String> {

    public static final String USER_ID_PREFIX = "user";
    public static final String USER_FOLDER = VIEWS_FOLDER + USERS_ID_PREFIX + "/" + USER_ID_PREFIX + "/";
    public static final String USER_ID_SUFFIX = "-view";
    public static final String USER_VIEW_ID = USER_ID_PREFIX + USER_ID_SUFFIX;
    public static final String USER_VIEW_NAME = "User";

    private final H1 label;

    public UserView() {
        setId(USER_VIEW_ID);
        addClassName(USER_VIEW_ID);

        setHeightFull();
        setAlignItems(CENTER);

        label = new H1("say what");
        add(label);

//        entityViewHeader = new EntityViewHeader(
//                getEntityType().getEntityIdPrefix(),
//                getEntityType().getEntityViewName(),
//                getEntityType().getEntityViewDescription(),
//                getEntityType().getEntityName(),
//                getEntityType().getEntitiesViewIcon()
//        );
//        add(entityViewHeader);
//
//        entityViewBody = getViewBody();
//        add(entityViewBody);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {
        selectedUserChanged(parameter);
    }

    private void selectedUserChanged(String selectedUserId) {
//        entityViewHeader.selectedEntityChanged(selectedEntityId);
//        entityViewBody.selectedEntityChanged(selectedEntityId);
        label.setText("selected user: " + selectedUserId);
    }
}
