package no.restaff.fresher.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import no.restaff.fresher.ui._Example_SearchBox;

public class _Example_Search implements Task {

    private final String searchTerm;

    protected _Example_Search(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(searchTerm)
                     .into(_Example_SearchBox.SEARCH_FIELD)
                     .thenHit(ENTER)
        );
    }

    public static _Example_Search forTheTerm(String searchTerm) {
        return instrumented(_Example_Search.class, searchTerm);
    }

}
