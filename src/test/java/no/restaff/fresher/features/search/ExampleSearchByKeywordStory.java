package no.restaff.fresher.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnElement;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import no.restaff.fresher.entity.User;
import no.restaff.fresher.tasks.FindUsernameInputField;
import no.restaff.fresher.ui.SignInBox;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import no.restaff.fresher.tasks.OpenTheSignInPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class ExampleSearchByKeywordStory {
    Actor anna = Actor.named("Anna");
    Actor david = Actor.named("David");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    private User user = new User("testbot@mailinator.com", "Password..1");

    @Steps
    OpenTheSignInPage openTheSignInPage;
    FindUsernameInputField findUsernameInputField;


    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(
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
                Click.on(SignInBox.NON_CSS_BUTTON),
                Enter.theValue(user.getUsername()).into(SignInBox.USERNAME_FIELD),
                Enter.theValue(user.getPassword()).into(SignInBox.PASSWORD_FIELD),
                Click.on(SignInBox.LOG_IN_BUTTON),
                Click.on(SignInBox.NAV_BAR_BTN),
                Click.on(SignInBox.REGISTER_DATA_MANAGER_BTN),
                Click.on(SignInBox.COMMENT_BTN),
                Click.on(SignInBox.CATEGORY_TYPE),
                Click.on(SignInBox.ADD_CATEGORY_BTN)
        );
    }
}