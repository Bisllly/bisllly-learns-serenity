package no.restaff.fresher.ui.comment_category_ui;

import net.serenitybdd.screenplay.targets.Target;

public class CreateCommentCategoryUI {

    //    public static final Target ADD_BUTTON = Target.the("add button")
//            .locatedBy("//button[@{0}='{1}']");
//    public static final Target ADD_BUTTON_NOT_HOVER = ADD_BUTTON
//            .of("title", "Add new Comment Category");

    public static final Target ADD_BUTTON_HOVER = Target.the("add button hover")
        .locatedBy("(//div[@id='app-site']//h6[text()='Comment Categories Register Data']" +
                "/ancestor::div[contains(@class,'MuiToolbar-gutters')]//div//button/span)[1]");
    public static final Target ADDED_DELETE_BUTTON = Target.the("added delete button")
            .locatedBy("//div[text()='{0}']/parent::div/parent::td/following-sibling::td//button[@title='Delete Comment Category']");
    public static final Target CONFIRM_DELETE_BTN = Target.the("confirm delete")
            .locatedBy("//span[text()='Delete']");

    public static final Target ADDED_EDIT_BUTTON = Target.the("added edit button")
            .locatedBy("//div[text()='{0}']/parent::div/parent::td/following-sibling::td//button[@title='Edit Comment Category']");
}
