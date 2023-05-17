package no.restaff.fresher.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import no.restaff.fresher.ui.SignInPage;

public class OpenTheSignInPage implements Task {

    SignInPage signInPage;

    @Step("Open the sign in page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(signInPage)
        );
    }
}
