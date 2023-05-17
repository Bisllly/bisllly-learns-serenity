package no.restaff.fresher.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.the;

public class SignInBox {
    public static final String USERNAME_FIELD = "//*[@id=\"app-site\"]/div/div/div/div[1]/div[2]/div[2]/form/fieldset/div[1]/div/input";
    public static final String NON_CSS_BUTTON = "//*[@id=\"app-site\"]/div/div/div/div[1]/div[2]/div[2]/form/fieldset/div[3]/span[3]/button";
    public static final String PASSWORD_FIELD = "//*[@id=\"app-site\"]/div/div/div/div[1]/div[2]/div[2]/form/fieldset/div[2]/div/input";
    public static final String LOG_IN_BUTTON = "//*[@id=\"app-site\"]/div/div/div/div[1]/div[2]/div[2]/form/fieldset/div[3]/span[1]/button";

    public static final String NAV_BAR_BTN = "//*[@id=\"app-site\"]/div/div/div/div/div[2]/header/div/button";
    public static final String REGISTER_DATA_MANAGER_BTN = "//*[@id=\"body\"]/div[2]/div[3]/ul/li[2]/div[7]/div";
    public static final String COMMENT_BTN = "//*[@id=\"body\"]/div[2]/div[3]/ul/li[2]/div[7]/div[2]/div/div/div/div[3]/div";
    public static final String CATEGORY_TYPE = "//body[1]/div[2]/div[3]/ul[1]/li[2]/div[7]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]";
    public static final String ADD_CATEGORY_BTN = "//button[@title='Add new Comment Category']";
}
