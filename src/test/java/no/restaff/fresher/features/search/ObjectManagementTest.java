package no.restaff.fresher.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import no.restaff.fresher.actions.ClearField;
import no.restaff.fresher.entity.BaseNominationObject;
import no.restaff.fresher.entity.User;
import no.restaff.fresher.ui.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import no.restaff.fresher.tasks.OpenTheSignInPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


@RunWith(SerenityRunner.class)
public class ObjectManagementTest {
    Actor david = Actor.named("David");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    private User user = new User("testbot@mailinator.com", "Password..1");
    private BaseNominationObject baseNominationObject = new BaseNominationObject("Nomination", "SMART Terminal");
    @Steps
    OpenTheSignInPage openTheSignInPage;


    @Before
    public void annaCanBrowseTheWeb() {
        david.can(
                BrowseTheWeb.with(herBrowser)
        );
    }

    @Test
    public void navigate_to_sign_in_page() {
        givenThat(david).wasAbleTo(openTheSignInPage);
    }
    @Test
    public void log_in_and_go_to_object_management() {
        david.attemptsTo(
                Click.on(SignInBox.NON_SSO_BUTTON),
                Enter.theValue(user.getUsername()).into(SignInBox.USERNAME_FIELD),
                Enter.theValue(user.getPassword()).into(SignInBox.PASSWORD_FIELD),
                Click.on(SignInBox.SIGN_IN_BUTTON),

                Click.on(NavigatorUI.NAV_BAR_BTN),
                Click.on(NavigatorUI.OBJECT_MANAGER_NAV),
                Pause.seconds(5),
                WaitUntil.the(ObjectManagementUI.ADD_OBJECT_TEMPLATE_BTN, isClickable()),
                Click.on(ObjectManagementUI.ADD_OBJECT_TEMPLATE_BTN),
                WaitUntil.the(ObjectManagementUI.NTH_OBJECT_TEMPLATE_TYPE, isClickable()),
                Click.on(ObjectManagementUI.FOURTH_OBJECT_TEMPLATE),

                ClearField.the(EditObjectTemplateUI.OBJECT_NAME_INPUT),
                Enter.theValue(baseNominationObject.getName()).into(EditObjectTemplateUI.OBJECT_NAME_INPUT),
                Enter.theValue(baseNominationObject.getTemplateCategory()).into(EditObjectTemplateUI.TEMPLATE_CATEGORY_INPUT),
                Enter.theValue(baseNominationObject.getTemplateSubscription()).into(EditObjectTemplateUI.TEMPLATE_SUBSCRIPTION_INPUT),

                Pause.seconds(5)
        );

    }
}