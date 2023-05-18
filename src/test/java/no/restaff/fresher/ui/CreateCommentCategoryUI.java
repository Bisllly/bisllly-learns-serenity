package no.restaff.fresher.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CreateCommentCategoryUI {


    //    public static final Target ADD_BUTTON = Target.the("add button")
//            .locatedBy("//button[@{0}='{1}']");
//    public static final Target ADD_BUTTON_NOT_HOVER = ADD_BUTTON
//            .of("title", "Add new Comment Category");
    public static final Target ADD_BUTTON_HOVER = Target.the("add button hover")
        .locatedBy("(//div[@id='app-site']//h6[text()='Comment Categories Register Data']" +
                "/ancestor::div[contains(@class,'MuiToolbar-gutters')]//div//button/span)[1]");
}
