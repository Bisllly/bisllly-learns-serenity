package no.restaff.fresher.tasks.sign_in;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import no.restaff.fresher.entity.User;
import no.restaff.fresher.ui.sign_in.SignInBox;

public class SignIn implements Task {

    private User user;

    public SignIn(User user) {
        this.user = user;
    }
    public static Performable asUser(User user) {
        return Tasks.instrumented(SignIn.class, user);
    }

    @Step("{0} signin as #user")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(SignInBox.NON_SSO_BUTTON),
            Enter.theValue(user.getUsername()).into(SignInBox.USERNAME_FIELD),
            Enter.theValue(user.getPassword()).into(SignInBox.PASSWORD_FIELD),
            Click.on(SignInBox.SIGN_IN_BUTTON)
        );
    }
}
