package org.karp.k4t.ui.automation.runner.views.home;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.karp.k4t.ui.automation.runner.element.retrieve.ElementRetriever;
import org.karp.k4t.ui.automation.runner.element.status.ElementStatus;
import org.karp.k4t.ui.automation.runner.element.status.mark.ElementStatusMarker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
@Service
@Slf4j
@Validated
public class HomeViewStatusMarker {

    @NotNull
    private final ElementRetriever elementRetriever;

    @NotNull
    private final HomeViewElementLocatorProvider homeViewElementLocatorProvider;

    @NotNull
    private final HomeLayoutElementLocatorProvider homeLayoutElementLocatorProvider;

    @NotNull
    private final HomeLayoutHeaderElementLocatorProvider homeLayoutHeaderElementLocatorProvider;

    @NotNull
    private final HomeLayoutTitleBarElementLocatorProvider homeLayoutTitleBarElementLocatorProvider;

    @NotNull
    private final HomeLayoutTitleRouterLinkElementLocatorProvider homeLayoutTitleRouterLinkElementLocatorProvider;

    @NotNull
    private final ApplicationImageElementLocatorProvider applicationImageElementLocatorProvider;

    @NotNull
    private final HomeLayoutTabsElementLocatorProvider homeLayoutTabsElementLocatorProvider;

    @NotNull
    private final HomeLayoutSearchBarElementLocatorProvider homeLayoutSearchBarElementLocatorProvider;

    @NotNull
    private final SearchBoxElementLocatorProvider searchBoxElementLocatorProvider;

    @NotNull
    private final HomeLayoutActionsBarElementLocatorProvider homeLayoutActionsBarElementLocatorProvider;

    @NotNull
    private final AuthenticationBarElementLocatorProvider authenticationBarElementLocatorProvider;

    @NotNull
    private final LoginRouterLinkElementLocatorProvider loginRouterLinkElementLocatorProvider;

    @NotNull
    private final LoginButtonElementLocatorProvider loginButtonElementLocatorProvider;

    @NotNull
    private final SignupRouterLinkElementLocatorProvider signupRouterLinkElementLocatorProvider;

    @NotNull
    private final SignupButtonElementLocatorProvider signupButtonElementLocatorProvider;

    @NotNull
    private final ElementStatusMarker elementStatusMarker;

    public void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull ElementStatus elementStatus) {
        log.info("Marking status '{}' for home view started", elementStatus.getName());
        List<By> locators = asList(
                homeViewElementLocatorProvider.getControlsContainer()/*,
                homeViewElementLocatorProvider.getBackgroundContainer(),
                homeLayoutElementLocatorProvider.getBackgroundContainer(),
                homeLayoutHeaderElementLocatorProvider.getBackgroundContainer()*/,
                homeLayoutTitleBarElementLocatorProvider.getBackgroundContainer(),
                homeLayoutTitleRouterLinkElementLocatorProvider.getBackgroundContainer(),
                applicationImageElementLocatorProvider.getControlsContainer(),
                homeLayoutTabsElementLocatorProvider.getBackgroundContainer(),
                homeLayoutTabsElementLocatorProvider.getHomeTab(),
                homeLayoutTabsElementLocatorProvider.getQuestionsTab(),
                homeLayoutTabsElementLocatorProvider.getQuizzesTab(),
                homeLayoutTabsElementLocatorProvider.getHomeTabRouterLink(),
                homeLayoutTabsElementLocatorProvider.getQuestionsTabRouterLink(),
                homeLayoutTabsElementLocatorProvider.getQuizzesTabRouterLink(),
                homeLayoutSearchBarElementLocatorProvider.getBackgroundContainer(),
                searchBoxElementLocatorProvider.getBackgroundContainer(),
                homeLayoutActionsBarElementLocatorProvider.getBackgroundContainer(),
                authenticationBarElementLocatorProvider.getBackgroundContainer(),
                loginRouterLinkElementLocatorProvider.getBackgroundContainer(),
                loginButtonElementLocatorProvider.getBackgroundContainer(),
                signupRouterLinkElementLocatorProvider.getBackgroundContainer(),
                signupButtonElementLocatorProvider.getBackgroundContainer()
        );
        mark(driver, locators, elementStatus);
        log.info("Marking status '{}' for home view completed", elementStatus.getName());
    }

    private void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull List<By> locators, @Valid @NotNull ElementStatus elementStatus) {
        for (By locator : locators) {
            mark(driver, locator, elementStatus);
        }
    }

    private void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull By locator, @Valid @NotNull ElementStatus elementStatus) {
        mark(driver, elementRetriever.getByPresence(driver, locator), elementStatus);
    }

    private void mark(@Valid @NotNull WebDriver driver, @Valid @NotNull WebElement element, @Valid @NotNull ElementStatus elementStatus) {
        elementStatusMarker.mark(driver, element, elementStatus);
    }
}
