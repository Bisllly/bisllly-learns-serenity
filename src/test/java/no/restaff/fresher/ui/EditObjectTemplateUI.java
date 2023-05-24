package no.restaff.fresher.ui;

import net.serenitybdd.screenplay.targets.Target;

public class EditObjectTemplateUI {
    public static final Target OBJECT_NAME_INPUT = Target.the("object name input")
            .locatedBy("//label[text()='Object Name']//following-sibling::div//input");
    public static final Target TEMPLATE_CATEGORY_INPUT = Target.the("template category input")
            .locatedBy("//input[@id='react-select-2-input']");
    public static final Target TEMPLATE_SUBSCRIPTION_INPUT = Target.the("template subscription input")
            .locatedBy("//input[@id='react-select-3-input']");
}
