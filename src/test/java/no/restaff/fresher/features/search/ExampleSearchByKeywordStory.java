package no.restaff.fresher.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import no.restaff.fresher.entity.Category;
import no.restaff.fresher.entity.User;
import no.restaff.fresher.tasks.FindUsernameInputField;
import no.restaff.fresher.ui.CreateCommentCategoryBox;
import no.restaff.fresher.ui.CreateCommentCategoryUI;
import no.restaff.fresher.ui.NavigatorUI;
import no.restaff.fresher.ui.SignInBox;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import no.restaff.fresher.tasks.OpenTheSignInPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


@RunWith(SerenityRunner.class)
public class ExampleSearchByKeywordStory {
    Actor anna = Actor.named("Anna");
    Actor david = Actor.named("David");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    private User user = new User("testbot@mailinator.com", "Password..1");
    public Category category = new Category("123");

    @Steps
    OpenTheSignInPage openTheSignInPage;
    FindUsernameInputField findUsernameInputField;


    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(
                BrowseTheWeb.with(herBrowser)
        );
        david.can(
                BrowseTheWeb.with(herBrowser)
        );
    }

    @Test
    public void navigate_to_sign_in_page() {
        givenThat(anna).wasAbleTo(openTheSignInPage);
    }
    @Test
    public void log_in_and_go_to_add() {
        anna.attemptsTo(
                Click.on(SignInBox.NON_SSO_BUTTON),
                Enter.theValue(user.getUsername()).into(SignInBox.USERNAME_FIELD),
                Enter.theValue(user.getPassword()).into(SignInBox.PASSWORD_FIELD),
                Click.on(SignInBox.SIGN_IN_BUTTON),
                Click.on(NavigatorUI.NAV_BAR_BTN),
                Click.on(SignInBox.REGISTER_DATA_MANAGER_BTN),
                Click.on(NavigatorUI.COMMENT_BTN),
                Click.on(NavigatorUI.CATEGORY_TYPE),
                Pause.seconds(5),
                WaitUntil.the(CreateCommentCategoryUI.ADD_BUTTON_HOVER, isVisible())
                        .forNoMoreThan(30).seconds(),
                Click.on(CreateCommentCategoryUI.ADD_BUTTON_HOVER),
                Pause.seconds(1),
                Enter.theValue(category.getName()).into(CreateCommentCategoryBox.COMMENT_CATEGORY_NAME_INPUT),
                Pause.seconds(1),
                Click.on(CreateCommentCategoryBox.COMMENT_CATEGORY_SAVE_BTN),
                Pause.seconds(3),
                Click.on(CreateCommentCategoryUI.ADDED_BUTTON.of(category.getName())),
                Click.on(CreateCommentCategoryUI.CONFIRM_DELETE_BTN),
                Pause.seconds(3)

        );
    }
}