package no.restaff.fresher.ui;

import net.serenitybdd.screenplay.targets.Target;

public class DeleteObjectTemplateBox {
    public static final Target CONFIRM_DELETE_BTN = Target.the("confirm delete btn")
            .locatedBy("//button/span[text()='Delete']");
}
