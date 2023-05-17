package no.restaff.fresher.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import no.restaff.fresher.tasks.OpenTheSignInPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class ExampleSearchByKeywordStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Steps
    OpenTheSignInPage openTheSignInPage;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void navigate_to_sign_in_page() {

        givenThat(anna).wasAbleTo(openTheSignInPage);

        when(anna).attemptsTo(
                //Search.forTheTerm("BDD In Action")

        );

        //hen(anna).should(eventually(seeThat(TheWebPage.title(), containsString("BDD In Action"))));

    }
}