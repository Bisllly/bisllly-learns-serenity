package no.restaff.fresher.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import no.restaff.fresher.entity.BaseNominationObject;
import no.restaff.fresher.entity.Category;
import no.restaff.fresher.entity.User;
import no.restaff.fresher.tasks.Pause;
import no.restaff.fresher.tasks.navigate_to.Navigate;
import no.restaff.fresher.tasks.operate_in.Operate;
import no.restaff.fresher.tasks.sign_in.SignIn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import no.restaff.fresher.tasks.sign_in.OpenThePage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;


@RunWith(SerenityRunner.class)
public class CommentCategoryTest {
    Actor anna = Actor.named("Anna");
    @Managed(uniqueSession = true)
    public WebDriver herBrowser;
    public Category category = new Category();
    private BaseNominationObject baseNominationObject = new BaseNominationObject("Nomination", "SMART Terminal");
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
    public void openSignInPage() {
        givenThat(anna).wasAbleTo(openThePage);
    }
    @Test
    public void navigateTo() {
        anna.attemptsTo(
                SignIn.asUser(user),
                Navigate.toCommentCategory(),
                Operate.inCommentCategory(category),
                Pause.seconds(3),

                Navigate.toObjectManagement(),
                Operate.inObjectManagement(baseNominationObject),
                Pause.seconds(10)
        );
    }
}