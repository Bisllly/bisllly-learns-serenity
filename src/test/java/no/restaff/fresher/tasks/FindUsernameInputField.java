package no.restaff.fresher.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import no.restaff.fresher.ui.SignInBox;
import no.restaff.fresher.ui._Example_SearchBox;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class FindUsernameInputField implements Task {
    SignInBox signInBox;
    private CharSequence username;

    public FindUsernameInputField(CharSequence username) {
        this.username = username;
    }

    @Step("Find the username input field")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username)
                        .into(SignInBox.USERNAME_FIELD)
//                        .thenHit(ENTER)
        );
    }
}
