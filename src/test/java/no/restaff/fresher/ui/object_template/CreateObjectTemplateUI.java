package no.restaff.fresher.ui.object_template;

import net.serenitybdd.screenplay.targets.Target;

public class CreateObjectTemplateUI {
    public static final Target OBJECT_NAME_INPUT = Target.the("object name input")
            .locatedBy("//label[text()='Object Name']//following-sibling::div//input");
    public static final Target TEMPLATE_CATEGORY_INPUT = Target.the("template category input")
            .locatedBy("//input[@id='react-select-2-input']");
    public static final Target TEMPLATE_SUBSCRIPTION_INPUT = Target.the("template subscription input")
            .locatedBy("//input[@id='react-select-3-input']");
    public static final Target SAVE_OBJECT_TEMPLATE_BTN = Target.the("save object template button")
            .locatedBy("//span[@title='Save Object Template']");
    public static final Target DELETE_OBJECT_TEMPLATE_BTN = Target.the("delete object template button")
            .locatedBy("//span[@title='Delete Object Template']");

    public static final Target STAGE_BTNS = Target.the("stage btns")
            .locatedBy("//button//p[text()='{0}']");
    public static final Target COLLECTION_STAGE_BTN = STAGE_BTNS.of("Collection");
    public static final Target FIELDS_STAGE_BTN = STAGE_BTNS.of("Fields");
    public static final Target RELATIONS_STAGE_BTN = STAGE_BTNS.of("Relations");
    public static final Target WORKFLOW_STAGE_BTN = STAGE_BTNS.of("Workflow");
    public static final Target NOTIFICATIONS_STAGE_BTN = STAGE_BTNS.of("Notifications");
    public static final Target VIEW_STAGE_BTN = STAGE_BTNS.of("View");
    public static final Target PUBLISH_STAGE_BTN = STAGE_BTNS.of("Publish");
}
