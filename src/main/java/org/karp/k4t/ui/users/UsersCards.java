package org.karp.k4t.ui.users;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import org.karp.k4t.model.User;
import org.karp.k4t.ui.users.user.UserView;

import static org.karp.k4t.ui.Styles.CSS_FILE_EXTENSION;
import static org.karp.k4t.ui.users.UsersCards.ID;
import static org.karp.k4t.ui.users.UsersView.FOLDER;

@CssImport(FOLDER + ID + CSS_FILE_EXTENSION)
public class UsersCards extends Div {

    public static final String ID = "users-cards";

    public UsersCards(UsersDataProvider usersDataProvider, UsersViewState usersViewState) {
        addClassName(ID);
        setWidthFull();
        Grid<User> grid = new Grid<>();
        setSizeFull();
        grid.setHeightFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(user -> createCard(user));
        grid.setItems(usersDataProvider.findAll());
        add(grid);
    }

    private HorizontalLayout createCard(User user) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("user-card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");

        UserAvatar avatar = new UserAvatar(user);
        VerticalLayout description = new VerticalLayout();
        description.addClassName("user-card-description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("user-card-header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        RouterLink name = new RouterLink(user.getFirstName() + " " + user.getLastName(), UserView.class, user.getId());
        name.addClassName("user-card-header-name");
        Span date = new Span(user.getDateOfRegistration().toString());
        date.addClassName("user-card-header-date");
        header.add(name, date);

        Span summary = new Span(user.getSummary());
        summary.addClassName("user-card-header-summary");

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("user-card-actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

        Icon likesIcon = VaadinIcon.HEART_O.create();
        likesIcon.addClassName("user-card-likes-icon");
        Span likesText = new Span(user.getLikes().toString());
        likesText.addClassName("user-card-likes-text");
        Icon commentsIcon = VaadinIcon.COMMENT_O.create();
        commentsIcon.addClassName("user-card-comments-icon");
        Span commentsText = new Span(user.getComments().toString());
        commentsText.addClassName("user-card-comments-text");
        Icon sharesIcon = VaadinIcon.CONNECT_O.create();
        sharesIcon.addClassName("user-card-shares-icon");
        Span sharesText = new Span(user.getShares().toString());
        sharesText.addClassName("user-card-shares-text");

        actions.add(likesIcon, likesText, commentsIcon, commentsText, sharesIcon, sharesText);

        description.add(header, summary, actions);
        card.add(avatar, description);
        return card;
    }
}
