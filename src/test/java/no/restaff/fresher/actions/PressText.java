package no.restaff.fresher.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;

public class PressText implements Interaction {

    private String textValue;

    public PressText(String textValue) {
        this.textValue = textValue;
    }

    @Override
    @Step("{0} focus and paste #textValue into field")
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).withAction().sendKeys(textValue).perform();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}