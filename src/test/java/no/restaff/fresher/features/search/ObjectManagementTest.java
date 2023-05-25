package no.restaff.fresher.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import no.restaff.fresher.actions.ClearField;
import no.restaff.fresher.actions.Press;
import no.restaff.fresher.entity.BaseNominationObject;
import no.restaff.fresher.entity.User;
import no.restaff.fresher.tasks.sign_in.SignIn;
import no.restaff.fresher.ui.*;
import no.restaff.fresher.ui.object_template.CreateObjectTemplateUI;
import no.restaff.fresher.ui.object_template.DeleteObjectTemplateBox;
import no.restaff.fresher.ui.object_template.ObjectManagementUI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import no.restaff.fresher.tasks.sign_in.OpenThePage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


@RunWith(SerenityRunner.class)
public class ObjectManagementTest {
    Actor david = Actor.named("David");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    private BaseNominationObject baseNominationObject = new BaseNominationObject("Nomination", "SMART Terminal");
    private static User user = new User("testbot@mailinator.com", "Password..1");
    @Steps
    OpenThePage openThePage;
    @Before
    public void annaCanBrowseTheWeb() {
        david.can(
                BrowseTheWeb.with(herBrowser)
        );
    }
    @Test
    public void navigate_to_sign_in_page() { givenThat(david).wasAbleTo(openThePage); }
    @Test
    public void log_in_and_go_to_object_management() {
        david.attemptsTo(
                SignIn.asUser(user),
                Click.on(NavigatorUI.NAV_BAR_BTN),
                Click.on(NavigatorUI.OBJECT_MANAGER_NAV),
                Pause.seconds(5),
                WaitUntil.the(ObjectManagementUI.ADD_OBJECT_TEMPLATE_BTN, isPresent()),
                WaitUntil.the(ObjectManagementUI.ADD_OBJECT_TEMPLATE_BTN, isClickable()),
                Click.on(ObjectManagementUI.ADD_OBJECT_TEMPLATE_BTN),
                WaitUntil.the(ObjectManagementUI.NTH_OBJECT_TEMPLATE_TYPE, isClickable()),
                Click.on(ObjectManagementUI.FOURTH_OBJECT_TEMPLATE),

                ClearField.the(CreateObjectTemplateUI.OBJECT_NAME_INPUT),
                Enter.theValue(baseNominationObject.getName()).into(CreateObjectTemplateUI.OBJECT_NAME_INPUT),
                Click.on(CreateObjectTemplateUI.TEMPLATE_CATEGORY_INPUT),
                Enter.theValue(baseNominationObject.getTemplateCategory()).into(CreateObjectTemplateUI.TEMPLATE_CATEGORY_INPUT),
                Pause.seconds(1),
                Press.aKey(Keys.TAB),
                Click.on(CreateObjectTemplateUI.TEMPLATE_SUBSCRIPTION_INPUT),
                Enter.theValue(baseNominationObject.getTemplateSubscription()).into(CreateObjectTemplateUI.TEMPLATE_SUBSCRIPTION_INPUT),
                Pause.seconds(1),
                Press.aKey(Keys.TAB),
                Click.on(CreateObjectTemplateUI.SAVE_OBJECT_TEMPLATE_BTN),
                Pause.seconds(10),
                WaitUntil.the(CreateObjectTemplateUI.RELATIONS_STAGE_BTN, isClickable()),
                Click.on(CreateObjectTemplateUI.FIELDS_STAGE_BTN),
                Pause.seconds(10),

                WaitUntil.the(CreateObjectTemplateUI.DELETE_OBJECT_TEMPLATE_BTN, isClickable()),
                Click.on(CreateObjectTemplateUI.DELETE_OBJECT_TEMPLATE_BTN),
                Pause.seconds(1),
                Click.on(DeleteObjectTemplateBox.CONFIRM_DELETE_BTN)
        );

    }
}