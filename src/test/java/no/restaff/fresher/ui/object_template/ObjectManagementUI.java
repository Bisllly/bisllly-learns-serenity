package no.restaff.fresher.ui.object_template;

import net.serenitybdd.screenplay.targets.Target;
import no.restaff.fresher.actions.RandomStringNumGenerator;

public class ObjectManagementUI {
    public static final Target PUBLISHED_ASSET = Target.the("published")
            .locatedBy("//h6[text()='{0}']");
    public static final Target PUBLISHED_OBJECTS = PUBLISHED_ASSET.of("Published Objects");
    public static final Target ADD_OBJECT_TEMPLATE_BTN = Target.the("add object template button")
            .locatedBy("//button[@title='Add Object Template']");
    public static final Target OBJECT_TEMPLATE_TYPES = Target.the("object template types")
            .locatedBy("//div[@class='MuiPaper-root MuiMenu-paper MuiPopover-paper MuiPaper-elevation8 MuiPaper-rounded']//ul//li[normalize-space(text()) != ''][{0}]");
    public static final Target FIRST_OBJECT_TEMPLATE = OBJECT_TEMPLATE_TYPES.of("1");
    public static final Target SECOND_OBJECT_TEMPLATE = OBJECT_TEMPLATE_TYPES.of("2");
    public static final Target THIRD_OBJECT_TEMPLATE = OBJECT_TEMPLATE_TYPES.of("3");
    public static final Target FOURTH_OBJECT_TEMPLATE = OBJECT_TEMPLATE_TYPES.of("4");
    public static final Target FIFTH_OBJECT_TEMPLATE = OBJECT_TEMPLATE_TYPES.of("5");

    public static final Target NTH_OBJECT_TEMPLATE_TYPE = OBJECT_TEMPLATE_TYPES.of(RandomStringNumGenerator.generateRandomStringNum());

    public static final Target BASE_OBJECT_FIELDS = Target.the("base object fields")
            .locatedBy("//div//p[text()='{0}']");

    public static final Target DISPLAY_OBJECT_FIELDS = Target.the("display object fields")
            .locatedBy("//div/h6[text()='OBJECT FIELDS']//parent::div//parent::div//following-sibling::div[count(div) = 1]");
}
