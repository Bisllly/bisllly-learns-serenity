package no.restaff.fresher.ui;

import net.serenitybdd.screenplay.targets.Target;

public class NavigatorUI {

    public static final Target MENU_ITEM =
            Target.the("{0} menu item")
                    .locatedBy("//div[text()='{0}']");
    public static final Target COMMENT_BTN = MENU_ITEM.of("Comments");
    public static final Target CATEGORY_TYPE =  MENU_ITEM.of("Categories");

    public static final Target NAV_BAR_BTN = Target.the("nav bar button")
            .locatedBy("//span[@class='menu-icon']");

}