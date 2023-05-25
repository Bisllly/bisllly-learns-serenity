package no.restaff.fresher.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.*;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import no.restaff.fresher.actions.ClearField;
import no.restaff.fresher.entity.Category;
import no.restaff.fresher.entity.User;
import no.restaff.fresher.tasks.sign_in.SignIn;
import no.restaff.fresher.ui.*;
import no.restaff.fresher.ui.comment_category_ui.CreateCommentCategoryBox;
import no.restaff.fresher.ui.comment_category_ui.CreateCommentCategoryUI;
import no.restaff.fresher.ui.comment_category_ui.UpdateCommentCategoryBox;
import no.restaff.fresher.ui.sign_in.SignInBox;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import no.restaff.fresher.tasks.sign_in.OpenThePage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


@RunWith(SerenityRunner.class)
public class CommentCategoryTest {
    Actor anna = Actor.named("Anna");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    public Category category = new Category();
    private static User user = new User("testbot@mailinator.com", "Password..1");
    @Steps
    OpenThePage openThePage;
    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(
                BrowseTheWeb.with(herBrowser)
        );
    }
    @Test
    public void navigate_to_sign_in_page() {
        givenThat(anna).wasAbleTo(openThePage);
    }
    @Test
    public void log_in_and_go_to_add() {
        anna.attemptsTo(
                SignIn.asUser(user),
                Click.on(NavigatorUI.NAV_BAR_BTN),
                Click.on(SignInBox.REGISTER_DATA_MANAGER_BTN),
                Click.on(NavigatorUI.COMMENT_BTN),
                Click.on(NavigatorUI.CATEGORY_TYPE),
                Pause.seconds(5),
                WaitUntil.the(CreateCommentCategoryUI.ADD_BUTTON_HOVER, isVisible())
                        .forNoMoreThan(30).seconds(),
                Click.on(CreateCommentCategoryUI.ADD_BUTTON_HOVER),
                Enter.theValue(category.getName()).into(CreateCommentCategoryBox.COMMENT_CATEGORY_NAME_INPUT),
                Click.on(CreateCommentCategoryBox.COMMENT_CATEGORY_SAVE_BTN),
                Click.on(CreateCommentCategoryUI.ADDED_EDIT_BUTTON.of(category.getName())),
                ClearField.the(UpdateCommentCategoryBox.COMMENT_CATEGORY_NAME_INPUT),
                Enter.theValue(category.getUpdatedName()).into(UpdateCommentCategoryBox.COMMENT_CATEGORY_NAME_INPUT),
                Click.on(UpdateCommentCategoryBox.COMMENT_CATEGORY_SAVE_BTN),
                Click.on(CreateCommentCategoryUI.ADDED_DELETE_BUTTON.of(category.getUpdatedName())),
                Click.on(CreateCommentCategoryUI.CONFIRM_DELETE_BTN),
                Pause.seconds(3)

        );
    }
}