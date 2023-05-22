package no.restaff.fresher.actions;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class Press implements Interaction, IsSilent {

    private Keys keys;

    public Press(Keys keys) {
        this.keys = keys;
    }

    public static Performable aKey(Keys keys) {
        return Tasks.instrumented(Press.class, keys);
    }

    public static Performable keys(String keys) {
        return Tasks.instrumented(PressText.class, keys);
    }

    @Override
    @Step("{0} press #keys key")
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).withAction().sendKeys(keys).perform();
//actor.attemptsTo(WaitForAutoCompleteToLoad.completed());
    }
}