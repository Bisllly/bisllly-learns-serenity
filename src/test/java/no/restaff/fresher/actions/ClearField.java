package no.restaff.fresher.actions;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.apache.commons.exec.OS;
import org.openqa.selenium.Keys;

public class ClearField implements Interaction, IsSilent {

    private Target target;

    public ClearField(Target target) {
        this.target = target;
    }

    public static Performable the(Target target) {
        return Tasks.instrumented(ClearField.class, target);
    }

    @Override
    @Step("{0} clear the #target")
    public <T extends Actor> void performAs(T actor) {
        this.target.resolveFor(actor).click();
        if (OS.isFamilyMac()){
            this.target.resolveFor(actor).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }else if (OS.isFamilyUnix()){
            this.target.resolveFor(actor).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
//this.target.resolveFor(actor).sendKeys(Keys.chord(Keys.COMMAND, "a"));
        actor.attemptsTo(Press.aKey(Keys.DELETE));
    }
}