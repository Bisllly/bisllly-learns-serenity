package no.restaff.fresher.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class Lift implements Interaction {

    private Target resource;
    private Target destination;

    public Lift(Target resource, Target destination) {
        this.resource = resource;
        this.destination = destination;
    }

    public static LiftBuilder from(Target source) {
        return new LiftBuilder(source);
    }

    @Override
    @Step("{0} drag [#resource] and drop to [#destination]")
    public <T extends Actor> void performAs(T theUser) {

        BrowseTheWeb.as(theUser).withAction()
                .moveToElement(this.resource.resolveFor(theUser), 2,2)
                .clickAndHold()
                .moveToElement(this.destination.resolveFor(theUser))
                .release(this.destination.resolveFor(theUser))
                .build()
                .perform();
    }

    public static class LiftBuilder {
        private Target source;

        public LiftBuilder(Target source) {
            this.source = source;
        }

        public Performable to(Target destination) {
            return Tasks.instrumented(Lift.class, source, destination);
        }
    }
}