package no.restaff.fresher.tasks.operate_in;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import no.restaff.fresher.actions.ClearField;
import no.restaff.fresher.actions.Press;
import no.restaff.fresher.entity.BaseNominationObject;
import no.restaff.fresher.tasks.Lift;
import no.restaff.fresher.tasks.Pause;
import no.restaff.fresher.ui.object_template.CreateObjectTemplateUI;
import no.restaff.fresher.ui.object_template.DeleteObjectTemplateBox;
import no.restaff.fresher.ui.object_template.ObjectManagementUI;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class OperateInObjectManagement implements Task {

    private BaseNominationObject baseNominationObject;

    public OperateInObjectManagement(BaseNominationObject baseNominationObject) {
        this.baseNominationObject = baseNominationObject;
    }

    @Override
    @Step("{0} operate in object management")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
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

                Lift.from(ObjectManagementUI.BASE_OBJECT_FIELDS.of("Services Total Amount")).to(ObjectManagementUI.DISPLAY_OBJECT_FIELDS),
                Pause.seconds(10),

                WaitUntil.the(CreateObjectTemplateUI.DELETE_OBJECT_TEMPLATE_BTN, isClickable()),
                Click.on(CreateObjectTemplateUI.DELETE_OBJECT_TEMPLATE_BTN),
                Pause.seconds(1),
                Click.on(DeleteObjectTemplateBox.CONFIRM_DELETE_BTN)
        );
    }
}
