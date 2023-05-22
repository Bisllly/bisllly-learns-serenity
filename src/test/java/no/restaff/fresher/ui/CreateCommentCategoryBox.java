package no.restaff.fresher.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CreateCommentCategoryBox {
    public static final Target COMMENT_CATEGORY_NAME_INPUT = Target.the("comment category name input")
            .locatedBy("//label[text()='Name']/following-sibling::div/input");
    public static final Target COMMENT_CATEGORY_SAVE_BTN = Target.the("comment category save btn")
            .locatedBy("//div[text()='Create Comment Category']/following-sibling::div[@class='MuiDialogActions-root jss121 MuiDialogActions-spacing']/child::button/span[text()='Save']");
}
